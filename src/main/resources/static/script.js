function mostrarModal(botaoClicado, modalId,location) {
  $(modalId).modal("show");
  $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
  $("#btnsim").on("click", function () {
    let botaoSim = $(this);
    let id = botaoSim.attr("data-id");
    $.ajax({
      url: location +"/remover/" + id,
      method: "Get",
      success: function () {
        window.location.href = location;
      },
    });
  });
}

$("#tabclientes").on("click", ".js-delete", function () {
  let botaoClicado = $(this);
  mostrarModal(botaoClicado, "#modalCliente","/clientes");
});

$("#tabdactes").on("click", ".js-delete", function () {
  let botaoClicado = $(this);
  mostrarModal(botaoClicado, "#modalDacte","/dactes");
});

$("#tabendereco").on("click", ".js-delete", function () {
  let botaoClicado = $(this);
  mostrarModal(botaoClicado, "#modalEndereco","/enderecosentrega");
});

$("#tabfornecedor").on("click", ".js-delete", function () {
  let botaoClicado = $(this);
  mostrarModal(botaoClicado, "#modalfornededor","/fornecedores");
});

$("#tabitemnota").on("click", ".js-delete", function () {
  let botaoClicado = $(this);
  mostrarModal(botaoClicado, "#modalItemNota","itensnota");
});

$("#tabnotasfiscal").on("click", ".js-delete", function () {
  let botaoClicado = $(this);
  mostrarModal(botaoClicado, "#modalNotaFiscal","notasfiscal");
});

$("#tabProdutos").on("click", ".js-delete", function () {
  let botaoClicado = $(this);
  mostrarModal(botaoClicado, "#modalProduto","produtos");
});

$("#tabregistros").on("click", ".js-delete", function () {
  let botaoClicado = $(this);
  mostrarModal(botaoClicado, "#modalRegistros","registrosarmazenamento");
});

$("#tabsituacao").on("click", ".js-delete", function () {
  let botaoClicado = $(this);
  mostrarModal(botaoClicado, "#modalSituacao","situacoens");
});
