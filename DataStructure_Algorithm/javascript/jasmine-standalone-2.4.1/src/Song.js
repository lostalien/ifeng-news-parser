function Song() {
	this.name = "hehe";
}

Song.prototype.persistFavoriteStatus = function(value) {
  // something complicated
  throw new Error("not yet implemented");
};

var song = new Song();
console.log( Object.keys(song) );
console.log( song instanceof Song );
