<template>
    <body>
      <div>
        <h1 class = "header">Wypożyczalnia samochodów</h1>
        <img class = "logo" src="./../assets/logo.png" width=100 height=100>
        <button class = "login" @click="callNLBrowseCarsApi()">Konto klienta</button>
<!--          <div>-->
<!--              <div class="card" id = "item1">-->
<!--                  <img class = "carsImages" src="./../assets/LC500.jpg" alt="Lexus LC500" style="width:300px;height:190px;">-->
<!--                  <h1>Lexus LC500</h1>-->
<!--                  <p class="price">1500 zł/24h</p>-->
<!--                  <p>Sportowa elegancja</p>-->
<!--                  <p><button>Specyfikacja i zamówienia</button></p>-->
<!--              </div>-->
<!--              <div class="card" id = "item2">-->
<!--                  <img class = "carsImages" src="./../assets/LS500h.jpg" alt="Lexus LC500" style="width:300px;height:190px;">-->
<!--                  <h1>Lexus LS500h</h1>-->
<!--                  <p class="price">1300 zł/24h</p>-->
<!--                  <p>Nieograniczony luksus</p>-->
<!--                  <p><button>Specyfikacja i zamówienia</button></p>-->
<!--              </div>-->
<!--              <div class="card" id = "item3">-->
<!--                  <img class = "carsImages" src="./../assets/seria3.jpg" alt="Lexus LC500" style="width:300px;height:190px;">-->
<!--                  <h1>BMW serii 3</h1>-->
<!--                  <p class="price">800 zł/24h</p>-->
<!--                  <p>Radość z jazdy</p>-->
<!--                  <p><button>Specyfikacja i zamówienia</button></p>-->
<!--              </div>-->
<!--              <div class="card" id = "item4">-->
<!--                  <img class = "carsImages" src="./../assets/mazda3.jpg" alt="Mazda 3" style="width:300px;height:190px;">-->
<!--                  <h1>Mazda 3</h1>-->
<!--                  <p class="price">700 zł/24h</p>-->
<!--                  <p>Hatchback z klasą</p>-->
<!--                  <p><button>Specyfikacja i zamówienia</button></p>-->
<!--              </div>-->
<!--              <div class="card" id = "item5">-->
<!--                  <img class = "carsImages" src="./../assets/megane.jpg" alt="Mazda 3" style="width:300px;height:190px;">-->
<!--                  <h1>Renoult Megane</h1>-->
<!--                  <p class="price">500 zł/24h</p>-->
<!--                  <p>Francuski przysmak</p>-->
<!--                  <p><button>Specyfikacja i zamówienia</button></p>-->
<!--              </div>-->
<!--              <div class="card" id = "item6">-->
<!--                  <img class = "carsImages" src="./../assets/octavia.jpg" alt="Mazda 3" style="width:300px;height:190px;">-->
<!--                  <h1>Skoda Octavia</h1>-->
<!--                  <p class="price">500 zł/24h</p>-->
<!--                  <p>Klasyka</p>-->
<!--                  <p><button>Specyfikacja i zamówienia</button></p>-->
<!--              </div>-->
<!--              <div class="card" id = "item7">-->
<!--                  <img class = "carsImages" src="./../assets/nissan.jpg" alt="Mazda 3" style="width:300px;height:190px;">-->
<!--                  <h1>Nissan Qashqai</h1>-->
<!--                  <p class="price">600 zł/24h</p>-->
<!--                  <p>SUV na Twoje potrzeby</p>-->
<!--                  <p><button>Specyfikacja i zamówienia</button></p>-->
<!--              </div>-->
<!--              <div class="card" id = "item8">-->
<!--                  <img class = "carsImages" src="./../assets/sandero.jpg" alt="Dacia Sandero" style="width:300px;height:190px;">-->
<!--                  <h1>Dacia Sandero</h1>-->
<!--                  <p class="price">400 zł/24h</p>-->
<!--                  <p>Podstawowy środek transportu</p>-->
<!--                  <p><button>Specyfikacja i zamówienia</button></p>-->
<!--              </div>-->
<!--          </div>-->

<!--     LOGOWANIE SIĘ --------------------------------------------------------------------------     -->
<!--          <div>-->
<!--              <div class="card" id = "loginCard">-->
<!--                  <img class = "carsImages" src="./../assets/avatarLogo.jpg" alt="Avatar" style="width:300px;height:300px;">-->
<!--                  <h1>Zaloguj się</h1>-->
<!--                  <form>-->
<!--                      <label for="username">Użytkownik</label><br>-->
<!--                      <input type="text" id="username" name="username" style="outline: 0; border-radius: 25px"><br>-->
<!--                      <label for="pwd">Hasło</label><br>-->
<!--                      <input type="password" id="pwd" name="pwd" style="outline: 0; border-radius: 25px">-->
<!--                  </form>-->
<!--                  <p style = "position: relative; bottom: 16px"><button>Login</button></p>-->
<!--              </div>-->
<!--          </div>-->
<!--     SPECYFIKACJA ---------------------------------------------------------------------------->
          <div>
              <img class = "carsImages" id="specificationImage" src="./../assets/seria3.jpg" alt="Lexus LC500">
              <div id = "specificationTable">
                  <table>
                      <tr>
                          <td>Moc</td>
                          <td style = "font-weight: bold; text-align: right">220 KM</td>
                      </tr>
                      <tr>
                          <td>Skrzynia biegów</td>
                          <td style = "font-weight: bold; text-align: right">Automatyczna</td>
                      </tr>
                      <tr>
                          <td>Napęd</td>
                          <td style = "font-weight: bold; text-align: right">RWD</td>
                      </tr>
                      <tr>
                          <td>Paliwo</td>
                          <td style = "font-weight: bold; text-align: right">Benzyna</td>
                      </tr>
                      <tr>
                          <td>Dopuszczalna ilość osób</td>
                          <td style = "font-weight: bold; text-align: right">5</td>
                      </tr>
                      <tr>
                          <td style = "font-weight: bold;">Cena</td>
                          <td style = "font-weight: bold; text-align: right">800 zł/km</td>
                      </tr>
                  </table>
                  <button class = "specificationButton" @click="callLCMakeOrder()">Zamów!</button>
              </div>
              <label class = "dateLabel" id="startLabel">Data rozpoczęcia: </label>
              <input class = "calendar" type="date" id="calendarStart"
                     value="2021-01-01"
                     min="2021-01-01" max="2022-01-01" v-model="d.fromTime">
              <label class = "dateLabel" id="endLabel">Data zakończenia: </label>
              <input class = "calendar" type="date" id="calendarEnd"
                     value="2021-01-02"
                     min="2021-01-02" max="2022-01-01" v-model="d.toTime">
              <h1 style="text-align: center; position: relative; bottom: 120px;">BMW serii 3</h1>
          </div>
      </div>
    </body>
</template>

<script>
import api from "../Api.js";

export default {
  name: 'NLBrowseCars',

  data () {
    return {
      cars: [],
      errors: [],
      d: {
        carId:3,
        fromTime:'',
        toTime:'',
        paymentLeft:800,
        insurance:false,
        kmLimit:200,
        toTheDoor:false
      }
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
	},
    callLCMakeOrder() {
      api.lcMakeOrder(this.d)
          .catch(error => {
            this.errors.push(error)
          })
    }
  }

}
</script>

<style>
    .header {
        border-radius: 25px;
        background: #abe800;
        margin: auto;
        padding: 20px;
        width: auto;
        height: 50%;
        text-align: center;
        font-weight: normal;
        font-size: 20px;
        color: #575757;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
    }

    .logo {
        position: relative;
        bottom: 82px;
        right: -30px;
    }

	.login {
		position: relative;
		background-color: #abe800;
		color: #575757;
		padding: 15px 32px;
		text-align: center;
		font-size: 16px;
		cursor: pointer;
		border-radius: 25px;
		border-color: #575757;
		bottom: 127px;
		left: 1220px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        outline: 0;
	}

    .card {
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        max-width: 300px;
        margin: auto;
        text-align: center;
        font-family: arial;
        border-radius: 25px;
    }

    .price {
        color: grey;
        font-size: 22px;
    }

    .card button {
        position: relative;
        border: none;
        outline: 0;
        padding: 12px;
        color: white;
        background-color: #575757;
        text-align: center;
        cursor: pointer;
        width: 100%;
        font-size: 18px;
        border-radius: 25px;
        bottom: -16px;
    }

    .card button:hover {
        opacity: 0.7;
    }

    .carsImages{
        border-radius: 25px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
    }

    #item1{
        position: absolute;
        bottom: 150px;
    }
    #item2{
        position: absolute;
        bottom: 150px;
        left: 410px;
    }
    #item3{
        position: absolute;
        bottom: 150px;
        left: 810px;
    }
    #item4{
        position: absolute;
        bottom: 150px;
        left: 1220px;
    }
    #item5{
        position: absolute;
        bottom: -350px;
    }
    #item6{
        position: absolute;
        bottom: -350px;
        left: 410px;
    }
    #item7{
        position: absolute;
        bottom: -350px;
        left: 810px;
    }
    #item8{
        position: absolute;
        bottom: -350px;
        left: 1220px;
    }

    #loginCard{
        bottom: 50px;
        position: relative;
    }

    #specificationImage{
        width:600px;
        height:345px;
        position: absolute;
        bottom: 220px;
    }
    #specificationTable {
        position: absolute;
        left: 800px;
        font-size: 20px;
        bottom: 285px;
    }
    .specificationButton{
        position: relative;
        background-color: #575757;
        color: white;
        padding: 15px 32px;
        text-align: center;
        font-size: 16px;
        cursor: pointer;
        border-radius: 25px;
        border-color: #575757;
        bottom: -68px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        outline: 0;
        width: 100%;
    }
    .specificationButton:hover{
        opacity: 0.7;
    }

    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 715px;
    }
    td, th {
        border: 0px solid #dddddd;
        text-align: left;
        padding: 8px;
    }
    tr:nth-child(even) {
        background-color: #dddddd;
    }

    .calendar{
        border-radius: 25px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        outline: 0;
        background-color: #abe800;
        position: absolute;
        bottom: 290px;
        font-size: 16px;
        color: #575757;
    }
    #calendarStart{
        right: 435px;
    }
    #calendarEnd{
        right: 24px;
    }
    .dateLabel{
        position: absolute;
        bottom: 293px;
        font-size: 20px;
    }
    #startLabel{
        right: 592px;
    }
    #endLabel{
        right: 182px;
    }

</style>
