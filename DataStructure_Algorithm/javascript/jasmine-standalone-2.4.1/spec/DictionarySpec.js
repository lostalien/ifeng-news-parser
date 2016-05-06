describe("测试Dictionary", function() {
	var dic;

	beforeEach(function() {
		dic = new Dictionary();
	});

	it("测试插入数据后列表大小", function() {
		dic.set("wp","王佩");
		dic.set("kyf","康云峰");
		dic.set("lf","刘菲");
		dic.set("hxj","黄晓静");
		
		expect(dic.size()).toEqual(4);
	});
  
	it("测试排序", function() {
		dic.set("wp","王佩");
		dic.set("kyf","康云峰");
		dic.set("lf","刘菲");
		dic.set("hxj","黄晓静");
		
		console.log( Object.keys(dic.getItems).sort());
		
		var arr = [];
		arr["d"] = 1;
		arr["f"] = 0;
		arr["a"] = "cc";
		
		console.log( Object.keys(arr).sort());
		
		expect(dic.size()).toEqual(4);
	});
	
	
});
