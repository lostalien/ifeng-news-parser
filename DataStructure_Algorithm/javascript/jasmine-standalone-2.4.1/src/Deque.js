function Deque() {
	this.dataStore = [];
	this.enqueue = enqueue;
	this.dequeue = dequeue;
	this.front = front;
	this.back = back;
	this.toString = toString;
	this.empty = empty;
	this.size = size;
	this.enqueueHead = enqueueHead;
	this.dequeueTail = dequeueTail;
	//从队尾加入队列
	function enqueue(elem){
		this.dataStore.push(elem);
	}
	//从队列头中删除
	function dequeue(){
		return this.dataStore.shift();
	}
	//向队列头处加入元素
	function enqueueHead(elem){
		this.dataStore.unshift(elem);
	}
	//删除队列尾部的元素
	function dequeueTail(){
		return this.dataStore.pop();
	}
	//查看列头元素
	function front(){
		return this.dataStore[0];
	}
	//查看列尾元素
	function back(){
		return this.dataStore[this.dataStore.length - 1];
	}

	function toString(){
		var retStr = "";
		for (var i = 0; i < this.dataStore.length; ++i) {
		  retStr += this.dataStore[i] + "\n";
		}
		return retStr;

	}
	//查看队列是否为空
	function empty(){
		if (this.dataStore.length == 0) {
		  return true;
		}
		else {
		  return false;
		}
	}
	//返回队列中的元素个数
	function size(){
		return this.dataStore.length;
	}
}
