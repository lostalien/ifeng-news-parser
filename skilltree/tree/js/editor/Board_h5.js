//网格板
define([
	"dojo/query"
	,"dojo/dom"
	,"dojo/dom-construct"
	,"dojo/dnd/Source"
	,"dojo/_base/declare"
	],function(query,dom,domConstruct,Source,declare){
	
		var Board = function( totalRow,totalCol){
			this.totalRow = totalRow;
			this.totalCol = totalCol;
			this.cells;
			var that = this;
			(function(){
				//console.log("这个自执行的函数中，this表示：" + that);
			})();
			
			//方法
			this.addCell = function(cell){
				if( !cell instanceof Source ){
					console.log("警告：" + "数组中加入了非Source类型的数据");
				}
				//如果cells还没初始化，那就初始化它
				if(!this.cells){
					this.cells = new Array(this.totalRow);
					for( var i = 0; i < this.totalRow; i++ ){
						this.cells[i] = new Array(this.totalCol);
					}					
				}
				var id = cell.id;
				this.cells[this.parseRowNumById(id)][this.parseColNumById(id)] = cell;				
			};
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
		};
		return Board;
		/*return declare(null, {
			totalRow : 0
			,totalCol : 0
			,cells : []//保存所有格子的数组
			,addCell : function( cell ){
				if( !cell instanceof Source ){
					console.log("警告：" + "数组中加入了非Source类型的数据");
				}
				var node = cell.node;
				var id = node.id;
				
				this.cells.push( cell );
			}
			,introSelf: function(){
				console.log("我是" + this.totalRow + " * " + this.totalCol );
			}
			,parseRowNumById : function(cellId){			
				var idparts = cellId.split("_");
				if( idparts.length != 3 ){
					throw new Error("单元格id的格式不对");
				}
				return idparts[1];
			}
			,parseColNumById : function(cellId){
				var idparts = cellId.split("_");
				if( idparts.length != 3 ){
					throw new Error("单元格id的格式不对");
				}
				return idparts[2];			
				
			}
		});*/
		
		/*return {
			totalRow : 0
			,totalCol : 0
			,cells : [][]//保存所有格子的数组
			,addCell : function( cell ){
				if( !cell instanceof Source ){
					console.log("警告：" + "数组中加入了非Source类型的数据");
				}
				this.cells[1][2]( cell );
			}
			,introSelf: function(){
				console.log("我是" + this.totalRow + " * " + this.totalCol );
			}
			
		}*/
});
