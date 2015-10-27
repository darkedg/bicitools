app.controller('domiciliarioController', ['$scope', '$http', '$state',
function($scope, $http, $state) {
	$scope.setMock(function(){
		$http.get('http://www.mocky.io/v2/5625a1ee250000c603ccb2cc').then(function(response){
			$scope.d = response.data;
			$scope.d.horario[0].dia = {};
			$scope.d.horario[0].dia["1"] = true;
			$scope.d.horario[0].dia["2"] = true;
			$scope.d.horario[0].dia["3"] = true;
			$scope.d.horario[1].dia = {};
			$scope.d.horario[1].dia["2"] = true;
			$scope.d.horario[1].dia["5"] = true;
			$scope.d.horario[1].dia["6"] = true;
		});
	});


	$scope.days = [
		{name: 'L', value: '2'},
		{name: 'Ma', value: '3'},
		{name: 'Mi', value: '4'},
		{name: 'J', value: '5'},
		{name: 'V', value: '6'},
		{name: 'S', value: '7'},
		{name: 'D', value: '1'}
	];

	$scope.hours = [];
	for (var h = 0; h <= 23; h++) {
		var hh = h < 10 ? '0' + h : h;
		['00','30'].forEach(function(j){
			$scope.hours.push(hh + ':' + j);
		});
	};

	$scope.d = {};
	$scope.d.horario = [{}];

	$scope.submit = function(){
		$scope.d.horario.forEach(function(e){
			var numbers = [];

			for (var key in e.dia) {
				if(e.dia[key] === true){
					numbers.push(key);
				}
			}
			e.dia = numbers;
		});

		$scope.post($scope.setDomiciliosPath('inscribirDomiciliario'), $scope.d, function(response){
			$state.go('domicilios');
		});
	};

	$scope.addSchedule = function(){
		$scope.d.horario.push({});
	}
	$scope.removeSchedule = function(index){
		if (index > -1) {
			$scope.d.horario.splice(index, 1);
		}
	}
}]);

app.controller('pedirServicioController', ['$scope', '$http', '$state', function($scope, $http, $state) {

	$scope.setMock(function(){
		$http.get('http://www.mocky.io/v2/5625adc32500003a06ccb2d9').then(function(response){
			$scope.s = response.data;
		});
	});

	$scope.submit = function(){
		$scope.post($scope.setDomiciliosPath('pedirServicioDomicilio'), $scope.s, function(response){
			$state.go('domicilios');
		});
	};
}]);

app.controller('aceptarServicioController', ['$scope', '$http', '$state',
function($scope, $http, $state) {

	$scope.setMock(function(){
		$http.get('http://www.mocky.io/v2/5625a5a9250000ab04ccb2d1').then(function(response){
			$scope.s = response.data;
		});
	});

	$scope.submit = function(){
		$scope.post($scope.setDomiciliosPath('aceptaServicioDomicilio'), $scope.s, function(response){
			$state.go('domicilios');
		});
	};
}]);

app.controller('registrarServicioController', ['$scope', '$http', '$state',
function($scope, $http, $state) {
	$scope.setMock(function(){
		$http.get('http://www.mocky.io/v2/5625a65f250000d204ccb2d6').then(function(response){
			$scope.s = response.data;
		});
	});

	$scope.submit = function(){
		$scope.post($scope.setDomiciliosPath('registrarServicioDomicilio'), $scope.s, function(response){
			$state.go('domicilios');
		});
	};
}]);