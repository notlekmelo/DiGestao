//Mensagens de alerta pagina

function msgError(msg) {
  $('#msg').html('<div class="alert alert-danger fade show">' + msg + '<button type="button" class="close" data-dismiss="alert" aria-label="Close" id="msgCross"><span aria-hidden="true">&times;</span></button></div>');
}

function msgSuccess(msg) {
  $('#msg').html('<div class="alert alert-success fade show">' + msg + '<button type="button" class="close" data-dismiss="alert" aria-label="Close" id="msgCross"><span aria-hidden="true">&times;</span></button></div>');
}

//Mensagens de alerta modal
function msgErrorModal(msg) {
  $('#msgModal').html('<div class="alert alert-danger fade show">' + msg + '<button type="button" class="close" data-dismiss="alert" aria-label="Close" id="msgCross"><span aria-hidden="true">&times;</span></button></div>');
}

function msgSuccessModal(msg) {
  $('#msgModal').html('<div class="alert alert-success fade show">' + msg + '<button type="button" class="close" data-dismiss="alert" aria-label="Close" id="msgCross"><span aria-hidden="true">&times;</span></button></div>');
}


var user = JSON.parse(sessionStorage.getItem('usuario'));
var msg = JSON.parse(sessionStorage.getItem('mensagem'));

if (user != null && user.status) {

  $('#formLogin').hide();
  $('#bemVindo').show();
  $('#bemVindo').html("Bem vindo, " + user.nome);

}else{
  $('#formLogin').show();
  $('#bemVindo').hide();
}

if (msg != null && msg.status) {
  if (msg.type == "success") {
    msgSuccess(msg.message);
  }else{
    msgError(msg.message)
  }
  sessionStorage.setItem('mensagem', null);
}

// lê se o usuário está logado com load da página
$( document ).ready(function() {
  
  if (sessionStorage.length != 0) {
      var us = JSON.parse(localStorage.getItem('pessoa'));
      var n = JSON.parse(localStorage.getItem('nutricionista'));
      var uL = JSON.parse(sessionStorage.getItem('userLogado'));
      if (uL == us.email) {
        $('#bem-vindo').append("<li style='color:orange'>Seja Bem Vindo, " + us.nome +"</li>");
        $('#bem-vindo').append("<button>Sair</button>");
        $('#bem-vindo button').attr("id", "btnSair");
        $('#bem-vindo button').attr("onclick", "limpaStorage()");
        document.getElementById("bem-vindo").style.display = "inline";
        document.getElementById("btnSair").style.display = "inline";
        document.getElementById("entrar-cadastro").style.display = "none";
      }
      if (uL == n.email) {
        $('#bem-vindo').append("<li style='color:orange'>Seja Bem Vindo, " + us.nome +"</li>");
        $('#bem-vindo').append("<button>Sair</button>");
        $('#bem-vindo button').attr("id", "btnSair");
        $('#bem-vindo button').attr("onclick", "limpaStorage()");
        document.getElementById("bem-vindo").style.display = "inline";
        document.getElementById("btnSair").style.display = "inline";
        document.getElementById("entrar-cadastro").style.display = "none";
      }
       
  }
});
function limpaStorage() {
  sessionStorage.clear();
  location.reload();
}
