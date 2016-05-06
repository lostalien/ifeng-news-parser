describe("测试BST", function() {
	var bst;

	beforeEach(function() {
		bst = new BST();
	});

	it("测试插入数据", function() {

		bst.insert(3);
		bst.insert(7);
		bst.insert(2);
		bst.insert(1);

		expect(bst.size).toEqual(4);		

	});
	
	it("测试中序遍历", function() {

		bst.insert(3);
		bst.insert(7);
		bst.insert(2);
		bst.insert(1);

		bst.inOrder( function(){
			console.log(arguments[0].key);
		});

		expect(bst.orderedKeys[0]).toEqual(1);
		expect(bst.orderedKeys[1]).toEqual(2);
		expect(bst.orderedKeys[2]).toEqual(3);
		expect(bst.orderedKeys[3]).toEqual(7);		

	});
	
	
	it("测试先序遍历", function() {

		bst.insert(3);
		bst.insert(7);
		bst.insert(2);
		bst.insert(1);
		bst.insert(6);
		bst.insert(9);		

		bst.preOrder( function(){
			console.log(arguments[0].key);
		});

		expect(bst.orderedKeys[0]).toEqual(3);
		expect(bst.orderedKeys[1]).toEqual(2);
		expect(bst.orderedKeys[2]).toEqual(1);
		expect(bst.orderedKeys[3]).toEqual(7);
		expect(bst.orderedKeys[4]).toEqual(6);		
		expect(bst.orderedKeys[5]).toEqual(9);

	});		
  
	it("测试后序遍历", function() {

		bst.insert(3);
		bst.insert(7);
		bst.insert(2);
		bst.insert(1);
		bst.insert(6);
		bst.insert(9);		

		bst.postOrder( function(){
			console.log(arguments[0].key);
		});

		expect(bst.orderedKeys[0]).toEqual(1);
		expect(bst.orderedKeys[1]).toEqual(2);
		expect(bst.orderedKeys[2]).toEqual(6);
		expect(bst.orderedKeys[3]).toEqual(9);
		expect(bst.orderedKeys[4]).toEqual(7);		
		expect(bst.orderedKeys[5]).toEqual(3);

	});
	
	it("测试获取最小值", function() {

		bst.insert(3);
		bst.insert(7);
		bst.insert(2);
		bst.insert(1);
		bst.insert(6);
		bst.insert(9);		

		expect(	bst.min() ).toEqual(1);

	});
	it("测试获取最大值", function() {

		bst.insert(3);
		bst.insert(7);
		bst.insert(2);
		bst.insert(1);
		bst.insert(6);
		bst.insert(9);		

		expect(	bst.max() ).toEqual(9);

	});
	
	it("测试查找特定的值", function() {

		bst.insert(3);
		bst.insert(7);
		bst.insert(2);
		bst.insert(1);
		bst.insert(6);
		bst.insert(9);		

		expect(	bst.search(3) ).toEqual(true);
		expect(	bst.search("he") ).toEqual(false);		
		expect(	bst.search(100) ).toEqual(false);
		
	});
	
	it("测试删除特定的值", function() {

		bst.insert(3);
		bst.insert(7);
		bst.insert(2);
		bst.insert(1);
		bst.insert(6);
		bst.insert(9);		


		expect(	bst.max() ).toEqual(9);
		expect(	bst.remove(9) ).toEqual(true);
		expect(	bst.max() ).toEqual(7);
		expect(	bst.size ).toEqual(5);
		
		
	});

	
});
