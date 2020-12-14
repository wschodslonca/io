<template>
  <div class="nlbrowsecars">
	<img src="./../assets/logo.png">
    <h1>Przegladanie samochodow</h1>
	<button @click="callNLBrowseCarsApi()">Browse</button>
	<ul>
		<li v-for="car in cars" :key="car">
			<ul>
				<li><h3>{{ car.model }}</h3></li>
				<li>{{ car.transmission }}</li>
				<li>{{ car.seats }}</li>
				<li>{{ car.fuel }}</li>
				<li>{{ car.drive }}</li>
				<li>{{ car.photoPath }}</li>
				<li>{{ car.price }}</li>
				<li>{{ car.promoRatio }}</li>
				<li>{{ car.status }}</li>
			</ul>
		</li>
	</ul>
  </div>
</template>

<script>
import api from "../Api.js";

export default {
  name: 'NLBrowseCars',
  
  data () {
	return {
		cars: [],
		errors: []
	}
  },
  
  methods: {
	callNLBrowseCarsApi() {
		api.nlcBrowseCars().then(response => {
			this.cars = response.data;
		})
		.catch(error => {
			this.errors.push(error)
		})
	}
  }
  
}
</script>

<style scoped>
h3 {
	color: blue;
}
li {
  display: inline;
  margin: 0 5px;
  color: green;
}
</style>
