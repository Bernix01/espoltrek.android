module.exports = function(app) {
	var student= require('./controllers/studentController');
	app.get('/', function(req, res, next) {
		return res.send("WELCOME TO REST API");
	});
	app.get('/otraRuta',function(req,res,next){
		return res.send("another page hehe");
	});

	app.post('/createStudent',student.createStudent); //Create Student API
	app.get('/getStudent',student.getStudent); //Gets ALL students details API
};
