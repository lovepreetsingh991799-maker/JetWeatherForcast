<img width="720" height="1600" alt="WhatsApp Image 2026-08-18 at 9 27 40 PM (1)" src="https://github.com/user-attachments/assets/9b520583-bf94-42b7-a3a3-e7d05a425e5a" />
<img width="720" height="1600" alt="WhatsApp Image 2026-08-18 at 9 27 40 PM" src="https://github.com/user-attachments/assets/0b27de52-bb29-47c3-ac77-f29e2f349844" />
<img width="720" height="1600" alt="WhatsApp Image 2026-08-18 at 9 27 39 PM (2)" src="https://github.com/user-attachments/assets/83765416-2a87-4b7e-80cc-00df8eb78f5d" />
<img width="720" height="1600" alt="WhatsApp Image 2026-08-18 at 9 27 39 PM (1)" src="https://github.com/user-attachments/assets/ead903e6-2cf2-42e2-bf18-4be1c9f65f06" />
<img width="720" height="1600" alt="WhatsApp Image 2026-08-18 at 9 27 39 PM" src="https://github.com/user-attachments/assets/e0abad43-ee44-45c8-b2d9-86fdf1e788a2" />
<img width="720" height="1600" alt="WhatsApp Image 2026-08-18 at 9 27 38 PM" src="https://github.com/user-attachments/assets/d2ff2afe-7dd8-41fa-8cc0-df9dc6b3a2ce" />
[README.md.md](https://github.com/user-attachments/files/31188204/README.md.md)
<h1>JetWeatherForecast</h1>
<p>Simple weather forecast app built with Kotlin and Jetpack Compose.</p>

<h2>About</h2>
<p>JetWeatherForecast is a simple Android weather application built with Kotlin and Jetpack Compose. It uses the OpenWeather API to show current weather and a multi-day forecast for a selected city. The app also supports favorite cities and temperature unit settings.</p>
<h2>Features</h2>
<ul>
<li>Search weather by city name</li>
<li>Show current temperature and weather condition</li>
<li>Show humidity, pressure and wind speed</li>
<li>Show sunrise and sunset</li>
<li>Show weekly weather forecast</li>
<li>Save and remove favorite cities</li>
<li>Switch between Imperial (°F) and Metric (°C)</li>
<li>Simple Compose-based UI with reusable components</li>
</ul>
<h2>Tech Stack</h2>
<ul>
<li>Kotlin</li>
<li>Jetpack Compose + Material 3</li>
<li>MVVM architecture</li>
<li>Hilt for dependency injection</li>
<li>Retrofit + Gson + OkHttp for networking</li>
<li>Kotlin Coroutines</li>
<li>Room Database for local data</li>
<li>Navigation Compose</li>
<li>Coil for weather images</li>
</ul>
<h2>Architecture</h2>
<p>The project follows a simple MVVM + Repository structure.</p>
<p>Compose UI → ViewModel → Repository → API / Room Database</p>
<p>WeatherRepository handles API data, while WeatherDbRepository handles favorite cities and unit settings.</p>
<h2>Main Screens</h2>
<ul>
<li>Splash Screen – starts the app and opens the default city.</li>
<li>Main Screen – displays current weather, weather details and weekly forecast.</li>
<li>Search Screen – allows the user to search for another city.</li>
<li>Favorite Screen – displays saved cities.</li>
<li>Settings Screen – changes the temperature unit.</li>
<li>About Screen – shows basic app information.</li>
</ul>
<h2>Project Structure</h2>
<ul>
<li>data/ – Room database, DAO and data wrapper</li>
<li>di/ – Hilt dependency injection module</li>
<li>model/ – weather and database models</li>
<li>network/ – OpenWeather Retrofit API</li>
<li>repository/ – network and local data repositories</li>
<li>screens/ – Compose screens and ViewModels</li>
<li>navigation/ – Navigation Compose setup</li>
<li>widgets/ – reusable Compose UI components</li>
<li>uitls/ – constants and utility functions</li>
<li>ui/theme/ – Compose theme files</li>
</ul>
<h2>API</h2>
<p>The app uses OpenWeather for forecast data.</p>
<p>Base URL: <code>https://api.openweathermap.org/</code></p>
<p>The API request sends the city, selected unit and API key.</p>
<h2>Local Storage</h2>
<ul>
<li>Room Database is used to store favorite cities and the selected temperature unit.</li>
<li>Favorites and settings can therefore remain available after the app is closed.</li>
</ul>
<h2>How to Run</h2>
<ul>
<li>1. Clone the repository.</li>
<li>2. Open the project in Android Studio.</li>
<li>3. Add your own OpenWeather API key.</li>
<li>4. Sync Gradle and run the app on an emulator or Android device.</li>
</ul>
<h2>Important</h2>
<ul>
<li>Do not upload your OpenWeather API key to a public GitHub repository.</li>
<li>The current project has the key inside Constants.kt. Before publishing, remove it from source code and use a secure local/build configuration instead.</li>
<li>If the existing key has already been pushed publicly, rotate/revoke it and create a new one.</li>
</ul>
<h2>Requirements</h2>
<ul>
<li>Android Studio</li>
<li>JDK 11</li>
<li>Minimum SDK: 29</li>
<li>Target/Compile SDK: 37</li>
<li>Internet connection for weather API requests</li>
</ul>
<h2>Future Improvements</h2>
<ul>
<li>Better API error and loading states</li>
<li>Current-location weather</li>
<li>Hourly forecast</li>
<li>Weather alerts</li>
<li>Dark mode</li>
<li>More unit options</li>
<li>More automated tests</li>
</ul>
<h2>Author</h2>
<ul>
<li>Lovepreet Singh</li>
<li>Android Developer | Kotlin | Jetpack Compose</li>
</ul>


