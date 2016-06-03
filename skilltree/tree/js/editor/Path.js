//技能
define([
	"dojo/query"
	,"dojo/dom"
	,"dojo/dom-construct"
	,"dojo/_base/declare"
	],function(query,dom,domConstruct,declare){
	
		var Path = function( row,col, id){
			this.row = row;
			this.col = col;
			this.id = id;
		}
		//移动到新的单元格
		Path.prototype.moveTo = function( x, y ){
			this.row = x;
			this.col = y;
		}
		return Path;

});
