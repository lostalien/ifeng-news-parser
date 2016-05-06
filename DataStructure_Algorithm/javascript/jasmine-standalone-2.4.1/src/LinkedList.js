/*基于链表的列表*/
function LinkedList() {
	this.head = new Node("head");//新建的链表只包含头元素
	this.tail = this.head;//新建的链表，尾指针也指向头部
	this.length = 0;//初始不包含任何元素
	this.add = add;
	this.set = set;
	this.size = size;
	this.get = get;

	//返回队列中的元素个数
	function size(){
		return this.length;
	}

	//添加元素（从尾部添加）
	function add(elem){
		var newNode = new Node(elem);
		this.tail.next = newNode;
		this.length++;
		this.tail = newNode;
		//console.log("this :" + this);
		//console.log("this.length :" + this.length);
	}
	//在制定的index之后添加
	function set(elem,index){
		var newNode = new Node(elem);
		if( index === 0){
			newNode.next = this.head.next;
			this.head.next = newNode;

		}else if( index === (this.length - 1) ){
			this.tail.next = newNode;
		}else{
			var targetNode = _getNode.call(this,index);
			var targetNodeBefore = _getNode.call(this,index - 1);
			targetNodeBefore.next = newNode;
			newNode.next = targetNode;
		}
		this.length++;
		return;		
			
	}
	//根据下标取得元素
	function get(index){
		console.log("试图取得下标" + index + "上的元素");
		var node = _getNode.call(this,index);
		return node.elem;
	}
	//根据下标取得节点
	function _getNode(index){
		console.log("this :" + this);		
		if( this.length === 0 ){
			throw new Error("列表中不含有元素");
		}
		//判断下标是否越界
		if( ( index > (this.length - 1) ) || ( index < 0 ) ){
			throw new Error("下标越界");
		}
		
		var currNode = this.head.next;
		var curr = 0;
		while( curr < index ){
			currNode = currNode.next;
			curr++;
		}
		
		return currNode;
	}
	//判断下标是否越界
	function _isValidIndex( index ){
		if( ( index > (this.length - 1) ) || ( index < 0 ) ){
			//throw new Error("下标越界");
			return true;
		}		
	}
	//删除元素
	function remove(index){
		if( !_isValidIndex.call(this,index) ){
			throw new Error("下标越界");
		}
		
		if( index === ( this.length - 1 ) ){//如果是删除尾部元素
			var targetBefore = _getNode.call(this,index - 1);
			var target = _getNode.call(this,index );
			targetBefore.next = null;
			target = null;
		}else{
			var targetBefore = _getNode.call(this,index - 1);
			var target = _getNode.call(this,index );
			targetBefore.next = target.next;
			target = null;
		}

	}
}

//节点类
function Node(elem){
	this.elem = elem;
	this.next = null;
}
