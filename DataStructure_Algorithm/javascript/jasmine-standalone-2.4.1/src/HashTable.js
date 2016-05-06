function HashTable() { 
	this.table = new Array(137); 
	this.simpleHash = simpleHash; 
	this.showDistro = showDistro; 
	this.put = function( key, value )
	//this.get = get; 
   
	var table = [];
	
	var loseloseHashCode = function(key){
		if( DH_StrUtils.isEmpty(key) ){
			throw new Error("键不能为空并且只能是字符串");
		}
		var hash = 0;
		for( var i = 0; i < key.length; i++){
			hash += key.charCodeAt(i);
		}
		
		return hash % 101;
	}
}
