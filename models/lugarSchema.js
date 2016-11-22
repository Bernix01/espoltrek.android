var LugarSchema= function(){
  var mongoose= require('../db').mongoose;
  var schema={
    nombre:{type:String,required=true},
    descripcion:{type:String,required=false;},
    etiquetas:{},
    coordenadas:{type: [Number] , index:'2d'},
    imagen:{}
  };
  var lugarSchema=mongoose.Schema(schema);
  var Lugar=mongoose.model('Lugar',lugarSchema);
  return Lugar;
};
module.exports = LugarSchema;
