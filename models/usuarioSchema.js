module.exports=function UsuarioSchema(){
  var mongoose=require('../db').mongoose;
  var schema={
    nombre:{type:String, required=true},
    nickname:{type:String, required=true},
    id:{type:String, required=true},
    contrasenia:{type:String, required=true},


  }
  var usuarioSchema=mongoose.Schema(schema);
  var Usuario=mongoose.model('Usuario',usuarioSchema);
  return Usuario;

};
