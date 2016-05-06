/*基于数组的列表*/
function ArrayList() {
	this.store = [];
	this.length = 0;//初始不包含任何元素
	this.add = add;
	this.set = set;
	this.size = size;
	this.get = get;
	this.remove = remove;
	
	//判断下标是否越界
	function _isValidIndex( index ){
		if( index > (this.store.length - 1) || ( index < 0 ) ){
			//throw new Error("下标越界");
			return false;
		}
		return true;
	}	

	//返回队列中的元素个数
	function size(){
		return this.store.length;
	}

	//添加元素（从尾部添加）
	function add(elem){
	
		this.store.push(elem);
		//console.log("this :" + this);
		//console.log("this.length :" + this.length);
	}
	//在set的index之后添加
	function set(elem,index){
		console.log("需要在下标" + index + "处插入数据" + elem);
		console.log("_isValidIndex.call(this,index):" + _isValidIndex.call(this,index));
		if( !_isValidIndex.call(this,index) ){
			throw new Error("下标越界");
		}
		if(index === (this.store.length - 1) ){
			this.add( elem );
		}else{
			this.store.splice(index,0,elem);
		}
			
	}


	//根据下标取得元素
	function get(index){
		console.log("试图取得下标" + index + "上的元素");
		if( !_isValidIndex.call(this,index) ){
			throw new Error("下标越界");
		}		
		return this.store[index];
	}
	//删除元素	
	function remove(index){
		if( !_isValidIndex.call(this,index) ){
			throw new Error("下标越界");
		}	
		this.store.splice(index,1);
	}
}
