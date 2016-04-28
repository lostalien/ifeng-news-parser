require([ "dojo/parser", "dijit/layout/BorderContainer",
	"dijit/layout/TabContainer", "dijit/layout/AccordionContainer",
	"dijit/layout/ContentPane", "dijit/layout/AccordionPane" ]);
	
//生成10*10的格子
require([
	"dojo/query"
	,"dojo/dom"
	,"dojo/dom-construct"
	,"dojo/dnd/Source"
	,"editor/Board"
	,"dojo/dom-class"
	,"dojo/dom-attr"
	,"editor/Skill"
	,"dojo/aspect"
	,"dojo/topic"
	,"dojo/NodeList-traverse"
	,"dojo/domReady!"]
	,function(query, dom, domConstruct, Source, Board, domClass, domAttr, Skill, aspect, topic ){
	
	console.log("开始生成10*10的格子");
	var totalRow = 10;
	var totalCol = 10;
	var board = new Board();
	board.totalRow = 10;
	board.totalCol = 10;
	
	var grid = dom.byId("grid");		
	var totalCells = totalRow * totalCol;
	for( var i = 0; i < totalCells; i++ ){
		//获取行号
		var rowNum = Math.floor(i / 10);
		//获取列号
		var colNum = i % 10;
		//创建单元格
		var cell = domConstruct.create(
			"div"
			,{
				className:"cell"
				,id : "cell_" + rowNum + "_" + colNum
				//,innerHTML:"<b>哈哈哈23223</b>"
			}
			,grid
		);
		//console.log("新建了一个cell，id为：" + cell.id);
		//将每个cell变为可拖拽Source
		var skillCell = new Source(cell.id,{ accept:['skill','path'], copyOnly:false, selfAccept:false });

		/*skillCell.on("dndCancel", function(){
			console.log("触发了dndCancel事件的处理函数");
			return false;
		});*/
		//给cell设置drop事件				
		skillCell.on("Drop",function(source,nodes,copy){
			var elem = nodes[0];
			
			//判断被移动的元素是skill还是path
			if( domAttr.get(elem,"dndtype") === "skill"){
			
				var skillId = domAttr.get(elem,"skillId");
				console.log("有一个技能 " + skillId + " 落在了：" + this.node.id);
				var skill = new Skill(
					board.parseRowNumById( this.node.id ),
					board.parseColNumById( this.node.id ),
					skillId
				);
				/*一个技能被拖到网格板上后，就只能在网格板上移动，不能再从技能池里拖拽一个相同的技能到网格板上了。实现思路如下：
					判断网格板上是否已经有这个技能了。如果没有，就在目标位置显示，如果有了，就在新的位置显示，在老的位置删除。
					通过判断来源，如果是从技能池里来了一个在网格板里已有的技能，那么就让当前拖拽操作无效。如果是从网格板里移动已存在的技能，
					那就在新的位置显示这个技能，在老位置删除。
				*/
				
				//判断来源
				var pId = query("#" + source.node.id ).parent()[0].id;
				console.log("拖拽技能来源:" + pId );
				//console.log( "target的: " + this.deleteSelectedNodes() );
				//console.log( "source的: " + source.selectNone() );
				if( board.hasSkill( skillId ) && pId === "skillPool"){//如果网格板中已有此技能，并且当前被拖拽的技能来自技能池
					console.log("拖拽来源是技能池，那么，返回false");
					//this.selectAll().deleteSelectedNodes();
					this.deleteSelectedNodes();
					//return false;
				}else{
					//将这个技能添加到board中
					console.log( "将技能放入网格板中" );
					board.addSkill( skill );						
				}

				board.showSkillKeys();
				
			}else if(domAttr.get(elem,"dndtype") === "path"){
				console.log("有一个路径 " + elem.id + " 落在了：" + this.node.id);
				if( domClass.contains(elem,"pathInPool")){
					//domClass.replace(elem,"pathOnBoard","pathInPool");
				}
			}
			
		});
		//将skillCell添加到Board中
		board.addCell(skillCell);
		//换行
		if( colNum === 9 ){
			domConstruct.create(
				"div"
				,{
					style:"clear:left"
				}
				,grid
			);
		}
						
	}
	console.log();
});