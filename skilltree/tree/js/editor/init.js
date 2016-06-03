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
	,"editor/BoardController"
	,"dojo/NodeList-traverse"
	,"dojo/domReady!"]
	,function(query, dom, domConstruct, Source, Board, domClass, domAttr, Skill, BoardController ){
	
	console.log("开始生成10*10的格子");
	var totalRow = 10;
	var totalCol = 10;
	//var board = new Board();
	//board.totalRow = 10;
	//board.totalCol = 10;
	//board.initCellArr();
	
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
		//将每个cell变为可拖拽Source
		var boardCell = new Source(cell.id,{ accept:['skill','path'], copyOnly:false, selfAccept:false });
		var boardController = new BoardController();
		//给cell设置drop事件				
		boardCell.on("Drop",function(source,nodes,copy){
			var target = this;			
			boardController.onDrop(source, nodes, target );
			
			//var elem = nodes[0];

			//判断被移动的元素是skill还是path
			// if( domAttr.get(elem,"dndtype") === "skill"){
			
			// 	var skillId = domAttr.get(elem,"skillId");
			// 	var skillNodeId = domAttr.get(elem,"id");
			// 	console.log("有一个技能 " + skillId + " 落在了：" + target.node.id);
			// 	var cellX = board.parseRowNumById( target.node.id );
			// 	var cellY = board.parseColNumById( target.node.id );
			// 	var skill = new Skill(
			// 		cellX,
			// 		cellY,
			// 		skillId
			// 	);
			// 	/*一个技能被拖到网格板上后，就只能在网格板上移动，不能再从技能池里拖拽一个相同的技能到网格板上了。实现思路如下：
			// 		判断网格板上是否已经有这个技能了。如果没有，就在目标位置显示，如果有了，就在新的位置显示，在老的位置删除。
			// 		通过判断来源，如果是从技能池里来了一个在网格板里已有的技能，那么就让当前拖拽操作无效。如果是从网格板里移动已存在的技能，
			// 		那就在新的位置显示这个技能，在老位置删除。
			// 	*/
				
			// 	//判断来源
			// 	var pId = query("#" + source.node.id ).parent()[0].id;
			// 	console.log("拖拽技能来源:" + pId );
			// 	//console.log( "target的: " + this.deleteSelectedNodes() );
			// 	//console.log( "source的: " + source.selectNone() );
				
			// 	if( pId === "skillPool"){//如果当前被拖拽的技能来自技能池
			// 		if( board.hasSkill( skillId ) ){//如果网格板中已有此技能
			// 			console.log("拖拽来源是技能池, selection:" + this.selection + "  " + this.anchor );
			// 			this.deleteSelectedNodes();
			// 			return;				
			// 		}
			// 		if( board.hasElementOnCell(cellX,cellY) ){//如果目标单元格上已经有内容
			// 			console.log("目标单元格上已有内容！");
			// 			//提醒用户，是否替换
			// 			var confirmRst = confirm("目标单元格上已有内容，要替换吗？");
			// 			if(confirmRst){
			// 				var curr = this.current;
			// 				var nod = this.node;
			// 				var map1 = this.map;
			// 				//this.deleteSelectedNodes();
			// 				this.selectAll().deleteSelectedNodes();
			// 				var testNode = dom.byId("test");
			// 				var s1 = this.selection;
			// 				var anc1 = this.anchor;
			// 				this.insertNodes( true, [curr] );
			// 				var all1 = this.getAllNodes();
			// 				console.log( "新技能覆盖了原有技能。" );
			// 				board.deleteSkill( board.getElementByCoordinate(cellX, cellY) );
			// 				board.addSkill( skill );
							
			// 			}else{
			// 				this.deleteSelectedNodes();
			// 				return;
			// 			}
			// 		}
			// 		console.log( "将技能 " + skill.id + " 放入网格板中" );
			// 		board.addSkill( skill );

			// 	}else{ //如果当前被拖拽的技能就来自网格板
			// 		if( board.hasElementOnCell(cellX,cellY) ){//如果目标单元格上已经有内容
			// 			console.log("目标单元格上已有内容！");
			// 			//提醒用户，是否替换
			// 			var confirmRst = confirm("目标单元格上已有内容，要替换吗？");
			// 			if(confirmRst){
			// 				//this.delItem(skillNodeId);
			// 				this.deleteSelectedNodes();
			// 			}else{
			// 				return;
			// 			}
			// 			console.log( "将技能放入网格板中" );
			// 			board.addSkill( skill );						
			// 		}
					
			// 	}

				
			// }else if(domAttr.get(elem,"dndtype") === "path"){
			// 	console.log("有一个路径 " + elem.id + " 落在了：" + target.node.id);
			// 	if( domClass.contains(elem,"pathInPool")){

			// 	}
			// }
			
		});
		//将skillCell添加到Board中
		//board.addCell(skillCell);
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

});