function Queue() {
	this.dataStore = [];
	this.enqueue = enqueue;
	this.dequeue = dequeue;
	this.front = front;
	this.back = back;
	this.toString = toString;
	this.empty = empty;
	//从队尾加入队列
	function enqueue(elem){
		this.dataStore.push(elem);
	}
	//从队列头中删除
	function dequeue(elem){
		this.dataStore.unshift();
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
}

var q = new Queue();
console.log("is empty? " + q.empty());
q.enqueue("haha");
q.enqueue("hehe");
q.enqueue("keke");
console.log(q.toString());
console.log("is empty? " + q.empty());

