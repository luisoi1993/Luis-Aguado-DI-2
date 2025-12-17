const selectPaises = document.getElementById("selectPaises");
const cartasEquipo = document.getElementById("cartasEquipo");
const nombresJugadores = document.getElementById("nombresJugadores");


fetch("https://www.thesportsdb.com/api/v1/json/123/all_countries.php")
  .then(res => res.json())
  .then(data => {
    data.countries.forEach(country => {
      const option = document.createElement("option");
      option.value = country.name_en;
      option.textContent = country.name_en;
      selectPaises.appendChild(option);
    });
  });


selectPaises.addEventListener("change", e => {
  const pais = e.target.value;
  cartasEquipo.innerHTML = `
    <div class="text-center text-white">
      <div class="spinner-border"></div>
      <p>Cargando equipos...</p>
    </div>
  `;

  fetch(`https://www.thesportsdb.com/api/v1/json/123/search_all_teams.php?s=Soccer&c=${pais}`)
    .then(res => res.json())
    .then(data => {
      cartasEquipo.innerHTML = "";

      if (!data.teams) {
        cartasEquipo.textContent = "No hay equipos disponibles";
        return;
      }

      data.teams.forEach(team => {
        const col = document.createElement("div");
        col.classList.add("col-md-4");

        const card = document.createElement("div");
        card.classList.add(
          "card",
          "team-card",
          "h-100",
          "animate__animated",
          "animate__zoomIn"
        );

        card.dataset.teamId = team.idTeam;

        card.innerHTML = `
          <img src="${team.strBadge}" class="card-img-top p-3" alt="${team.strTeam}">
          <div class="card-body text-center">
            <h5 class="card-title">${team.strTeam}</h5>
            <button class="btn btn-danger favorite-btn">
               Ver jugadores
            </button>
          </div>
        `;

        col.appendChild(card);
        cartasEquipo.appendChild(col);
      });
    });
});


cartasEquipo.addEventListener("click", e => {
  if (!e.target.classList.contains("favorite-btn")) return;

  const teamCard = e.target.closest(".team-card");
  const teamId = teamCard.dataset.teamId;

  nombresJugadores.innerHTML = `
    <div class="text-center">
      <div class="spinner-border text-primary"></div>
      <p>Cargando jugadores...</p>
    </div>
  `;

  fetch(`https://www.thesportsdb.com/api/v1/json/123/lookup_all_players.php?id=${teamId}`)
    .then(res => res.json())
    .then(data => {
      nombresJugadores.innerHTML = "";

      if (!data.player) {
        nombresJugadores.textContent = "No hay jugadores disponibles";
        return;
      }

      data.player.forEach(player => {
        const p = document.createElement("p");
        p.classList.add("animate__animated", "animate__fadeInUp");
        p.textContent = `⚽ ${player.strPlayer}`;
        nombresJugadores.appendChild(p);
      });
    });
});
