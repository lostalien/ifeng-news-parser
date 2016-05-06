function Graph(){
	var vertices = [];
	var adjList = new Dictionary();
	
	this.addVertex = function(v){
	
		console.log( vertices[v] );
		console.log( adjList.get(v) );
		//var items = adjList.getItems();
	
		if( !vertices[v] && !adjList.get(v) ){
				
			vertices.push(v);
			adjList.set( v, [] );
			
		}else{
		
			throw new Error("非法添加");
			
		}
	}
	
	this.addEdge = function(v,w){
		//var items = adjList.getItems();
		var adjV = adjList.get(v);
		var adjW = adjList.get(w);
		if( adjV && adjW ){
			adjV.push(w);
			adjW.push(v);		
		}else{
			throw new Error("非法添加");
		}
	}
	//私有方法
	var initializeColor = function(){
		var color = [];
		for( var i = 0; i < vertices.length; i++ ){
			color[vertices[i]] = 'white';
		}
		return color;
	}
	
	var printNode = function( v ){
		console.log( "Visited vertex : " + v );
	}
	
	
	this.bfs = function( v, callback ){
		var color = initializeColor();
		var queue = new Deque();
		queue.enqueue( v );
		
		while( !queue.empty() ){
			var u = queue.dequeue();
			var neighbors = adjList.get(u);
			color[u] = 'grey';
			for( var i = 0; i < neighbors.length; i++ ){
				var nb = neighbors[i];
				if( color[nb] === 'white' ){
					color[nb] = 'grey';
					queue.enqueue( nb );

				}
			}
			
			color[u] = 'black';
			if( callback ){
				callback( u );
			}
		}
	}
	
	this.bfs2 = function( v ){
		var color = initializeColor();
		var queue = new Deque();
		queue.enqueue( v );
		var d = [];
		var pred = [];
		
		for( var j = 0; j < vertices.length; j++ ){
			d[ vertices[j] ] = 0;
			pred[ vertices[j] ] = null;
		}		
		while( !queue.empty() ){
			var u = queue.dequeue();
			var neighbors = adjList.get(u);
			color[u] = 'grey';
			for( var i = 0; i < neighbors.length; i++ ){
				var nb = neighbors[i];
				if( color[nb] === 'white' ){
					color[nb] = 'grey';
					queue.enqueue( nb );
					d[nb] = d[u] + 1;
					pred[nb] = u;					
				}
			}
			
			color[u] = 'black';
			return {
				distances : d
				,predecessor: pred
			}
		}		
	}

	/*打印出类似这样的效果
	A	->	B	C	D	
	B	->	A	E	F	
	C	->	A	D	G	
	D	->	A	C	G	H	
	E	->	B	I	
	F	->	B	
	G	->	C	D	
	H	->	D	
	I	->	E
	 */
	this.toString = function(){
		var v = "";
		var s = "";
		for( var i = 0; i < vertices.length; i++ ){
			v = vertices[i];
			s += v;
			s += " -> "
			var adj = "";
			var adjlist = adjList.get(v);
			for( var j = 0; j < adjList.get(v).length; j++ ){
				adj = adjList.get(v)[j];
				s += " " + adj;
			}
			s += "\n";
		}
		console.log(s);
	}
	
}