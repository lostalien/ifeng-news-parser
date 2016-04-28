//技能
define([
	"dojo/query"
	,"dojo/dom"
	,"dojo/dom-construct"
	,"dojo/_base/declare"
	],function(query,dom,domConstruct,declare){
	
		var Skill = function( row,col, id){
			this.row = row;
			this.col = col;
			this.id = id;
			var that = this;
		}
		
		return Skill;

});
