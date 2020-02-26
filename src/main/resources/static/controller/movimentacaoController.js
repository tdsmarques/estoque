(function(){
    getMovimentacaos();
  })();
var selectedRow = null
var idTemp = null   

function carregarOption(){
    obterCliente()
    obterProdutos()
}

function obterCliente(){
    var url = "http://localhost:3030/cliente"; 
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, false);
    xhttp.send();
    var clientes = JSON.parse(xhttp.responseText);

    clientes.forEach(function(item){
        $('#form_nomeCliente').append('<option value="' + item.nome + '">' + item.nome + '</option>');
    });
}

function obterProdutos(){
    var url = "http://localhost:3030/produto"; 
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, false);
    xhttp.send();
    var produtos = JSON.parse(xhttp.responseText);

    produtos.forEach(function(item){
        console.log(item)
        $('#form_nomeProduto').append('<option value="' + item.nome + '">' + item.nome + '</option>');
    });
}

function getMovimentacaos(){
    var url = "http://localhost:3030/movimentacao"; 
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, false);
    xhttp.send();
    var myArr = JSON.parse(xhttp.responseText);
    
    myArr.forEach(function(movimentacao){
            inserirNovaLinha(movimentacao)
      });
}

function enviarForm() {
    if (validate()) {
        var formData = lerInfoForm();
        if (selectedRow == null){
            inserirNovaLinha(formData);
            salvarMovimentacao(formData);
            limpaForm();
            idTemp = null
        }
        else {
            atualizarMovimentacao(formData);            
        }
        limpaForm()            
    }
}

function salvarMovimentacao(data){

    var json = JSON.stringify(data);
    var url = "http://localhost:3030/movimentacao";
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", url, false);
    xhttp.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhttp.send(json);
}

function lerInfoForm() {
    var formData = {};
    formData["nomeCliente"] = document.getElementById("form_nomeCliente").value;
    formData["nomeProduto"] = document.getElementById("form_nomeProduto").value;
    formData["tipoMovimentacao"] = document.getElementById("form_tipoMovimentacao").value;
    formData["qtdMovimentacao"] = document.getElementById("form_qtdMovimentacao").value;
    return formData;
}

function inserirNovaLinha(data) {
    var table = document.getElementById("movimentacaoList").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.length);
    cell0 = newRow.insertCell(0);
    cell0.innerHTML = data.nomeCliente;
    cell1 = newRow.insertCell(1);
    cell1.innerHTML = data.nomeProduto;
    cell2 = newRow.insertCell(2);
    cell2.innerHTML = data.tipoMovimentacao;
    cell3 = newRow.insertCell(3);
    cell3.innerHTML = data.qtdMovimentacao;    
    cell4 = newRow.insertCell(4);
    cell4.innerHTML = `<button type="button" onClick="editarMovimentacao(this)" data-toggle="modal" data-target="#exampleModalCenter" class="btn btn-warning">Editar</button>
                       <button type="button" onClick="excluirMovimentacao(this)" class="btn btn-danger">Excluir</button>`;
    cell5 = newRow.insertCell(5);
    cell5.innerHTML = data.id
    cell5.setAttribute("style", "display:none;");
    cell5.setAttribute("id", "indentificador" + newRow.rowIndex)
}

function limpaForm() {
    document.getElementById("form_nomeCliente").value = "";
    document.getElementById("form_nomeProduto").value = "";
    document.getElementById("form_tipoMovimentacao").value = "ENTRADA";
    document.getElementById("form_qtdMovimentacao").value = "";
    selectedRow = null;
}

function editarMovimentacao(td) {
    selectedRow = td.parentElement.parentElement;

    nomeCliente = selectedRow.cells[0].innerHTML
    $('#nomeCliente').remove()
    $('#form_nomeCliente').append('<option id="nomeCliente" value="' + nomeCliente + '">' + nomeCliente + '</option>');

    nomeProduto= selectedRow.cells[1].innerHTML
    $('#nomeProduto').remove()
    $('#form_nomeProduto').append('<option id="nomeProduto" value="' + nomeProduto + '">' + nomeProduto + '</option>');

    document.getElementById("form_tipoMovimentacao").value = selectedRow.cells[2].innerHTML;
    document.getElementById("form_qtdMovimentacao").value = selectedRow.cells[3].innerHTML;

    idTemp = selectedRow.cells[5].innerHTML;
}

function atualizarMovimentacao(formData) {

    var json = JSON.stringify(formData);
    var url = "http://localhost:3030/movimentacao/" + idTemp;
    var xhttp = new XMLHttpRequest();
    xhttp.open("PUT", url, false);
    xhttp.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhttp.send(json);

    selectedRow.cells[0].innerHTML = formData.nomeCliente;
    selectedRow.cells[1].innerHTML = formData.nomeProduto;
    selectedRow.cells[2].innerHTML = formData.tipoMovimentacao;
    selectedRow.cells[3].innerHTML = formData.qtdMovimentacao;    
}

function excluirMovimentacao(td) {
    if (confirm('Tem certeza que deseja deletar?')) {
        linha = td.parentElement.parentElement;
        id = linha.cells[5].innerHTML;
        var url = "http://localhost:3030/movimentacao/" + id; 
        var xhttp = new XMLHttpRequest();
        xhttp.open("DELETE", url, false);
        xhttp.send();
        document.getElementById("movimentacaoList").deleteRow(linha.rowIndex);
    }
}

function validate() {    
    isValid = true;
    if (document.getElementById("form_nomeCliente").value == "" || 
        document.getElementById("form_nomeProduto").value == "" ||
        document.getElementById("form_qtdMovimentacao").value == "") {
        alert("Existem Campos em Branco")
        return isValid = false;
    }
    return isValid;
}