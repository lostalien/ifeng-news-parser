describe("测试LinkedList", function() {
	var linkedlist;

	beforeEach(function() {
		linkedlist = new LinkedList();
	});

	it("测试插入数据后列表大小", function() {
		linkedlist.add(3);
		linkedlist.add(7);
		linkedlist.add(2);
		linkedlist.add(1);
		
		expect(linkedlist.size()).toEqual(4);
	});
  
	it("测试取得指定位置的数据", function() {
		linkedlist.add(3);
		linkedlist.add(7);
		linkedlist.add(2);
		linkedlist.add(1);
		var d0 = linkedlist.get(0);
		var d1 = linkedlist.get(1);
		var d2 = linkedlist.get(2);
		var d3 = linkedlist.get(3);
		
		expect(d0).toEqual(3);
		expect(d1).toEqual(7);
		expect(d2).toEqual(2);
		expect(d3).toEqual(1);		
	});
	
	it("测试取数据时下标越界", function() {
		linkedlist.add(3);
		linkedlist.add(7);
		linkedlist.add(2);
		linkedlist.add(1);
		
		expect(function() {
			linkedlist.get(-1);
		}).toThrowError("下标越界");
		
		expect(function() {
			linkedlist.get(9);
		}).toThrowError("下标越界");
		
	});
	
	it("测试在指定位置上插入数据", function() {
		linkedlist.add(3);
		linkedlist.add(7);
		linkedlist.add(2);
		linkedlist.add(1);
		linkedlist.set(9,0);
		linkedlist.set(0,4);
		
		expect(linkedlist.get(0)).toEqual(9);
		expect(linkedlist.get(5)).toEqual(0);		
		
	});	
});
