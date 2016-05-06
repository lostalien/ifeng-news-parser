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
		this.dataStore.unshift();
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
}

var q = new Queue();
console.log("is empty? " + q.empty());
q.enqueue("haha");
q.enqueue("hehe");
q.enqueue("keke");
console.log(q.toString());
console.log("is empty? " + q.empty());

