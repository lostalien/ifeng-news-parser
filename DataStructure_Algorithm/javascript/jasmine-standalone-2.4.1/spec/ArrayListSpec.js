describe("测试ArrayList", function() {
	var arraylist;

	beforeEach(function() {
		arraylist = new ArrayList();
	});

	it("测试插入数据后列表大小", function() {
		arraylist.add(3);
		arraylist.add(7);
		arraylist.add(2);
		arraylist.add(1);
		
		expect(arraylist.size()).toEqual(4);
	});
  
	it("测试取得指定位置的数据", function() {
		arraylist.add(3);
		arraylist.add(7);
		arraylist.add(2);
		arraylist.add(1);
		var d0 = arraylist.get(0);
		var d1 = arraylist.get(1);
		var d2 = arraylist.get(2);
		var d3 = arraylist.get(3);
		
		expect(d0).toEqual(3);
		expect(d1).toEqual(7);
		expect(d2).toEqual(2);
		expect(d3).toEqual(1);		
	});
	
	it("测试取数据时下标越界", function() {
		arraylist.add(3);
		arraylist.add(7);
		arraylist.add(2);
		arraylist.add(1);
		
		expect(function() {
			arraylist.get(-1);
		}).toThrowError("下标越界");
		
		expect(function() {
			arraylist.get(9);
		}).toThrowError("下标越界");
		
	});
	
	it("测试在指定位置上插入数据", function() {
		arraylist.add(3);
		arraylist.add(7);
		arraylist.add(2);
		arraylist.add(1);
		arraylist.set(9,0);
		arraylist.set(0,4);
		
		expect(arraylist.get(0)).toEqual(9);
		expect(arraylist.get(5)).toEqual(0);		
		
	});	
});
