var Class = function(){
  var klass = function(){
    this.init.apply(this, arguments);
  };
  klass.prototype.init = function(){};
  return klass;
};
var Person = new Class();