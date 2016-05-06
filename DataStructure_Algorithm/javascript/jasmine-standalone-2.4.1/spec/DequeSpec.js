describe("测试双向队列", function() {
  var deque;

  beforeEach(function() {
    deque = new Deque();
  });

  it("应该包含2个元素", function() {
    deque.enqueue(9);
	deque.enqueue(3);
    expect(deque.size()).toEqual(2);
  });
  
  it("3应该在队列尾", function() {
    deque.enqueue(9);
	deque.enqueue(3);
    expect(deque.back()).toEqual(3);
  });  

  it("测试头部添加和尾部删除", function() {
    deque.enqueueHead(7);
	deque.enqueueHead(4);
	deque.enqueueHead(1);	
    expect(deque.front()).toEqual(1);
	
	deque.dequeueTail();
	expect(deque.back()).toEqual(4);
  });
});

describe("判断回文", function() {
	var deque;

	beforeEach(function() {
		deque = new Deque();
	});

	it("回文3721273", function() {
		var w = "3721273";
		for(var i = 0; i < w.length; i++){
			deque.enqueue(w.charAt(i));
		}
		var s = "";
		for(var j = 0; j < w.length; j++){
			s += deque.dequeueTail();
		}

		expect(s).toEqual(w);
	});
});