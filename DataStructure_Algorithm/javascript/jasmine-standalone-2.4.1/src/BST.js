/*基于数组的列表*/
function BST() {
	this.size = 0;//初始不包含任何元素
	this.insert = insert;
	this.inOrder = inOrder;
	this.preOrder = preOrder;
	this.postOrder = postOrder;
	this.orderedKeys = [];
	this.min = min;
	this.max = max;
	this.search = search;
	this.remove = remove;
	
	var root = null;
	
	function insert(key){
	
		var newNode = new Node(key);
		
		if( root === null ){
			root = newNode;
			this.size++;
		}else{
			_insertNode.call( this,root,newNode );
		}
	}
	
	function _insertNode( node, newNode){
	
		if( newNode.key <= node.key){
		
			if( node.left === null ){
				node.left = newNode;
				this.size++;
			}else{
				_insertNode.call( this, node.left, newNode );
			}
			
		}else{
		
			if( node.right === null ){
				node.right = newNode;
				this.size++;
			}else{
				_insertNode.call( this, node.right,newNode );
			}
			
		}
	}
	
	//中序遍历
	function inOrder(callback){
		if( root === null ){
			throw new Error( "树中没有数据" );
		}
		_inOrder.call( this, root, callback );
	}
	
	function _inOrder( node, callback ){

		if( node != null ){
			_inOrder.call( this,node.left, callback );
			callback(node);
			this.orderedKeys.push(node.key);
			_inOrder.call( this,node.right, callback );
		}		
	}
	//先序遍历
	function preOrder( callback ){
		if( root === null ){
			throw new Error( "树中没有数据" );
		}
		_preOrder.call( this, root, callback );
		
	}
	
	function _preOrder( node, callback ){
	
		if( node != null ){
			callback(node);
			this.orderedKeys.push(node.key);		
			_preOrder.call( this,node.left, callback );
			_preOrder.call( this,node.right, callback );
		}
		
	}
	//后序遍历
	function postOrder( callback ){
		if( root === null ){
			throw new Error( "树中没有数据" );
		}
		_postOrder.call( this, root, callback );
	}
	function _postOrder( node, callback ){
	
		if( node != null ){		
			_postOrder.call( this, node.left, callback );
			_postOrder.call( this, node.right, callback );
			callback(node);
			this.orderedKeys.push(node.key);			
		}
		
	}
	//查找最小值
	function min(){
		//todo 不能对空树进行查找
		if( root === null ){
			throw new Error( "树中没有数据" );
		}
		
		var node  = root;
		while( node.left ){
			node = node.left;
		}
		return node.key;
	}
	
	//查找最大值
	function max(){
		if( root === null ){
			throw new Error( "树中没有数据" );
		}
		
		var node  = root;
		while( node.right ){
			node = node.right;
		}
		return node.key;		
	}
	//查找特定的值
	function search(key){
		if( root === null ){
			throw new Error( "树中没有数据" );
		}	
		var node = _searchNode.call(this, root, null, key);
		if( node )
			return true;
		else
			return false;
	}
	
	function _searchNode( node, pbranch, key ){
		console.log("当前节点为：" + node.key);
		if( node === null ){
			return false;
		}
		if( key === node.key ){
			node.pbranch = pbranch;//临时添加的属性
			return node;
		}
		if( key < node.key ){
			return _searchNode.call(this, node.left, node.left, key);
		}else if( key > node.key ){
			return _searchNode.call(this, node.right, node.right, key);
		}
		
	}
	//删除树中某个值
	function remove(key){
		if( root === null ){
			throw new Error( "树中没有数据" );
		}	
		var rst = _removeNode2.call( this, root, key );
		if( rst )
			return true;
		else
			return false;
		
		//var node = _searchNode.call( this, root, null, key );
		
		//if( node ){//如果待删除的值存在与树中
			
		//	return _removeNode.call( this,  node );

		//}else{//如果待删除的值不在树中
		//	return false;
		//}
	}
	
	function _findMaxNode( node ){
		if( node.right === null ){
			return node;
		}else{
			return _findMaxNode.call(this, node.right );
		}
	}
	
	function _removeNode( node,key ){
		
		
		//如果是叶子节点
		if( node.left === null && node.right === null ){
		
			node.pbranch = null;
			this.size--;
			return true;
			
		}else if(  node.left !== null && node.right === null ){//如果只有左子树
			
			node.pbranch = node.left;
			node = null;
			this.size--;
			return true;
			
		}else if( node.right !== null && node.left === null ){//如果只有右子树
			
			node.pbranch = node.right;
			node = null;
			this.size--;
			return true;				
			
		}else{//如果左右都有，就找到左子树里最大的
		
			var leftMaxNode = _findMaxNode.call( this, node.left, node.left );
			node.key = leftMaxNode.key;
			//_removeNode.call( this, leftMaxNode );
			leftMaxNode.pbranch = null;
			this.size--;
			return true;	
			
		}
	}
}

	function _removeNode2( node, key ){
	
		if( node === null ){
		
			return null;
			
		}
		if( key < node.key ){
		
			node.left =  _removeNode2.call( this, node.left, key );
			return node;
			
		}else if( key > node.key ){
		
			node.right = _removeNode2.call( this, node.right, key );		
			return node;
			
		}else if( key === node.key ){
		
			if( node.left === null && node.right === null ){
				node = null;
				this.size--;
				return node;
			}else if( node.left !== null && node.right === null ){
				node = node.left;
				this.size--;
				return node;
			}else if( node.right !== null && node.left === null ){
				node = node.right;
				this.size--;
				return node;
			}else{//如果左右都有，就找到左子树里最大的
				
				var leftMaxNode = _findMaxNode.call( this, node.left );
				node.key = leftMaxNode.key;
				node.left = _removeNode2.call( this, node.left, leftMaxNode.key );
				return node;
			}
			
		}
	}
function Node(key){
	this.key = key;
	this.left = null;
	this.right = null;
	this.pbranch  = null;//只在个别方法里用上了
};	

