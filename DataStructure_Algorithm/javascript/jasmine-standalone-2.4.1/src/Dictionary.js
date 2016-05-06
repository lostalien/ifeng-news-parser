function Dictionary() {
	var items = {};
	
	this.set = function(key, value) {
		items[key] = value;
	}
	
	this.has = function(key){
		return key in items;
	}
	
	this.remove = function(key){
		if	(this.has(key)){
			delete	items[key];
			return	true;
		}
		return	false;
	}
	
	this.get = function(key){
		return this.has(key) ? items[key] : undefined;
	}
	
	this.values = function(){
		var values = [];
		for( var k in items ){
			if( this.has( k ) ){
				values.push = items[k];
			}
		}
		return values;
	}
	
	this.size = function(){
		return Object.keys( items ).length;
	}
	
	this.clear = function(){
		items = {};
	}
	
	this.getItems = function(){
		return items;
	}
	
	this.showAll = function() { 
	   for(var key in Object.keys(this.store)) { 
		  console.log(key + " -> " + this.store[key]); 
	   } 
	} 	
}
