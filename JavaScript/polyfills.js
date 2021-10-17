// for each
Array.prototype.myForEach = function(callback) {
  for (let i = 0; i < this.length; i++) {
    callback(this[i],i,this);
  }
}
let array0 = [1,2,3];
array0.myForEach((item)=>console.log(item))

// map
Array.prototype.myMap = function(callback) {
  let newArray = [];
  for (let i = 0; i < this.length; i++) {
    newArray.push(callback(this[i],i,this));
  }
  console.log(newArray);
  return newArray;
}
let array = [1,2,3];
array.myMap((item)=>item+2)

// filter
Array.prototype.myFilter = function(callback) {
  let newArray = [];
  for (let i = 0; i < this.length; i++) {
  let result = callback(this[i],i,this);
  if(result){
    newArray.push(this[i]);
    }
  }
  console.log(newArray);
  return newArray;
}
let array1 = [1,2,3];
array1.myFilter((item)=>item>1)
