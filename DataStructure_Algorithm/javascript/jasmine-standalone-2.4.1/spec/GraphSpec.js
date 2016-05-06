describe("测试Graph", function() {
	var graph;

	beforeEach(function() {
		graph = new Graph();
	});

	it("测试添加节点和边", function() {
	
		var	myVertices	=	['A','B','C','D','E','F','G','H','I'];
		for( var i = 0; i < myVertices.length; i++ ){
			console.log("准备添加节点：" + myVertices[i] )
			graph.addVertex( myVertices[i] );
		}
		graph.addEdge('A',	'B');
		graph.addEdge('A',	'C');
		graph.addEdge('A',	'D');
		graph.addEdge('C',	'D');
		graph.addEdge('C',	'G');
		graph.addEdge('D',	'G');
		graph.addEdge('D',	'H');
		graph.addEdge('B',	'E');
		graph.addEdge('B',	'F');
		graph.addEdge('E',	'I');
		
		graph.toString();
		
	});
	
 	it("测试广度优先搜索（BFS）", function() {
	
		var	myVertices	=	['A','B','C','D','E','F','G','H','I'];
		for( var i = 0; i < myVertices.length; i++ ){
			console.log("准备添加节点：" + myVertices[i] )
			graph.addVertex( myVertices[i] );
		}
		graph.addEdge('A',	'B');
		graph.addEdge('A',	'C');
		graph.addEdge('A',	'D');
		graph.addEdge('C',	'D');
		graph.addEdge('C',	'G');
		graph.addEdge('D',	'G');
		graph.addEdge('D',	'H');
		graph.addEdge('B',	'E');
		graph.addEdge('B',	'F');
		graph.addEdge('E',	'I');
		
		var ExploredOrder = function( v ){
			var rst = "";
			this.record = function(v){
				rst += v;
			}
			this.getRst = function(){
				return rst;
			}
		};
		
		var eo = new ExploredOrder();
		
		var printNode = function(v){
			console.log(v);
		}
		//打印顺序应该是ABCDEFGHI
		graph.bfs('A', eo.record );	
		
		expect(eo.getRst()).toEqual("ABCDEFGHI");
	});
});
