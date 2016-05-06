function Queue() {
	this.dataStore = [];
	this.enqueue = enqueue;
	this.dequeue = dequeue;
	this.front = front;
	this.back = back;
	this.toString = toString;
	this.empty = empty;
   
	function enqueue(elem){
		this.dataStore.push(elem);
	}
   
	function dequeue(elem){
		this.dataStore.shift();
	}

	function front(){
		return this.dataStore[0];
	}

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

