//网格板
define([
	"dojo/query"
	,"dojo/dom"
	,"dojo/dom-construct"
	//,"dojo/dnd/Source"
	,"editor/Skill"
	,"dojo/_base/declare"
	],function(query,dom,domConstruct,Source,Skill, declare){
	
		var Board = function( totalRow,totalCol){
			this.totalRow = totalRow;
			this.totalCol = totalCol;
			var cellArr;
			var skillMap = {};
			var that = this;
			
			//初始化cellArr
			this.initCellArr = function(){
				if(!cellArr){
					cellArr = new Array(this.totalRow);
					for( var i = 0; i < this.totalRow; i++ ){
						cellArr[i] = new Array(this.totalCol);
					}					
				}
				
			}
			
			//向网格板中添加一个技能
			this.addSkill = function( sk ){
				if( !sk instanceof Skill ){
					throw new Error("非法的参数类型");
				}
				//先向map中添加
				skillMap[sk.id] = sk;
				//再向数组中添加
				cellArr[sk.row][sk.col] = sk;
				
			}
			
			this.setSkill = function( sk )
			
			//查看是否已有某个技能
			this.hasSkill = function( skillId ){
				if( skillMap[skillId] ){
					return true;
				}else{
					return false;
				}
			}			
			
			//查看某个单元格上是否已有内容
			this.hasElementOnCell = function( x,y ){
				if( !cellArr[x][y] ){
					return false;
				}else{
					return true;
				}
			}
			//得到某个单元格上的元素
			this.getElementByCoordinate = function( x, y ){
				return cellArr[x][y];
			}
			//方法
			this.addCell = function(cell){
				if( !cell instanceof Source ){
					console.log("警告：" + "数组中加入了非Source类型的数据");
				}
				//如果cells还没初始化，那就初始化它
				if(!cellArr){
					cellArr = new Array(this.totalRow);
					for( var i = 0; i < this.totalRow; i++ ){
						cellArr[i] = new Array(this.totalCol);
					}					
				}
				var node = cell.node;
				var id = node.id;
				cellArr[this.parseRowNumById(id)][this.parseColNumById(id)] = cell;				
			};
			//将技能或者路径添加到坐标中
			
			//方法
			this.parseRowNumById = function(cellId){
				var idparts = cellId.split("_");
				if( idparts.length != 3 ){
					throw new Error("单元格id的格式不对");
				}
				return idparts[1];					
			};
			//方法
			this.parseColNumById = function(cellId){
				var idparts = cellId.split("_");
				if( idparts.length != 3 ){
					throw new Error("单元格id的格式不对");
				}
				return idparts[2];				
			};
			
			//调试用
			this.showSkillKeys = function(){
				console.log( "网格板中包含有如下技能:" + Object.keys(skillMap) );
			}
			//调试用
			this.showGraphicBoard = function(){
				var str = "";
				for( var i = 0; i < cellArr.length; i++ ){
					for( var j = 0; j < cellArr[i].length; j++ ){
						if( cellArr[i][j] ){
							var skill = cellArr[i][j];
							str += skill.id + " " + skill.row + " " + skill.col;
							
						}else{
							str += "               ";
						}
					}
					str += "\n";
				}
				
				console.log(str);
			}
			
		};
	
		return Board;

});
