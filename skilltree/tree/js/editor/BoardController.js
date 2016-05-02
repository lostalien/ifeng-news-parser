//网格板
define([
	"dojo/query"
	,"dojo/dom"
	,"dojo/dom-construct"
	,"dojo/dom-class"
	,"dojo/dom-attr"	
	,"dojo/dnd/Source"
	,"dojo/_base/lang"
	,"editor/Skill"
	,"editor/Board"
	],function(query,dom,domConstruct, domClass, domAttr, Source, lang, Skill, Board){
	
		var BoardController = function(){
			
			var board = new Board();
			board.totalRow = 10;
			board.totalCol = 10;			
			board.initCellArr();
			
			//处理元素放置元素到网格板
			this.onDrop = function( source,nodes,target ){
				
				var elem = nodes[0];
				var targetX = board.parseRowNumById( target.node.id );
				var targetY = board.parseColNumById( target.node.id );
				
				//判断来源
				var pId = query("#" + source.node.id ).parent()[0].id;
				console.log("拖拽技能来源:" + pId );
				if( pId === "skillPool" ){//如果当前被拖拽的元素来自技能池	
					
					var skillId = domAttr.get(elem,"skillId");
					var skillNodeId = domAttr.get(elem,"id");
					
					if( board.hasSkill( skillId ) ){//如果网格板中已有此技能
						console.log("拖拽来源是技能池, selection:" + target.selection + "  " + target.anchor );
						alert("网格板中已有此技能！");
						target.deleteSelectedNodes();
						return;
					}
					
					if( board.hasElementOnCell(targetX,targetY) ){//判断目标单元格上是否已有元素，如果有，就不能直接放置在上面，而要先删除已有元素才行。
						console.log("目标单元格上已有内容！");
						alert("目标单元格上已有内容，请先将其删除！");
						target.deleteSelectedNodes();
						return;
						//提醒用户，是否替换
						// var confirmRst = confirm("目标单元格上已有内容，要替换吗？");
						// if(confirmRst){
						// 	var curr = this.current;
						// 	var nod = this.node;
						// 	var map1 = this.map;
						// 	//this.deleteSelectedNodes();
						// 	this.selectAll().deleteSelectedNodes();
						// 	var testNode = dom.byId("test");
						// 	var s1 = this.selection;
						// 	var anc1 = this.anchor;
						// 	this.insertNodes( true, [curr] );
						// 	var all1 = this.getAllNodes();
						// 	console.log( "新技能覆盖了原有技能。" );
						// 	board.deleteSkill( board.getElementByCoordinate(targetX, targetY) );
						// 	board.addSkill( skill );
							
						// }else{
						// 	this.deleteSelectedNodes();
						// 	return;
						// }
					}
					var skill = new Skill(
						targetX,
						targetY,
						skillId
					);					
					console.log( "将技能 " + skill.id + " 放入网格板中" );
					board.addSkill( skill );	
									
				}else if( pId === "pathPool" ){//如果当前被拖拽的元素来自路径池
					if( board.hasElementOnCell(targetX,targetY) ){//判断目标单元格上是否已有元素，如果有，就不能直接放置在上面，而要先删除已有元素才行。
						console.log("目标单元格上已有内容！");
						alert("目标单元格上已有内容，请先将其删除！");
						target.deleteSelectedNodes();
						return;						
					}
					var pathId = domAttr.get(elem,"pathId");
					var pathNodeId = domAttr.get(elem,"id");					
					console.log( "将路径 " + pathId + " 放入网格板中" );
					var path = new Path(
						targetX,
						targetY,
						pathId
					);
					board.addPath( path );
				}else{//来自网格板
					
					if( board.hasElementOnCell(targetX,targetY) ){//判断目标单元格上是否已有元素，如果有，就不能直接放置在上面，而要先删除已有元素才行。
						console.log("目标单元格上已有内容！");
						alert("目标单元格上已有内容，请先将其删除！");
						var currNode = lang.clone(target.current);
						source.insertNodes( false, [currNode] );
						target.deleteSelectedNodes();
						return;						
					}else{
						var sourceParentNode = source.parent;
						var sourceX = board.parseRowNumById( sourceParentNode.id );
						var sourceY = board.parseColNumById( sourceParentNode.id );
						var dndtype = domAttr.get(elem,"dndtype");
						if( dndtype === "skill" ){//如果是技能
							
							var sk = board.getElementByCoordinate( sourceX, sourceY );
							sk.x = targetX;
							sk.y = targetY;
							board.
						}else if( dndtype === "path" ){//如果是路径
							
						}
					}	
				}
				
				
				board.showGraphicBoard();
				board.showSkillKeys();													
			}
		}
		
		return BoardController;
});
