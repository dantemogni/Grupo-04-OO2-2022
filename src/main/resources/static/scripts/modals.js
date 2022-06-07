

  $("#traditionalDetailsModal").on("show.bs.modal", function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
  
    var bancos = button.data("bancos");
    var pizarron = button.data("pizarron");
    var proyector = button.data("proyector");

    var modal = $(this);
  

    if(proyector){
      proyector = "✅ Si"
    } else {
      proyector = "❌ No"
    }

    modal.find("#classroomBancos").text(bancos);
    modal.find("#classroomPizarron").text(pizarron);
    modal.find("#classroomProyector").text(proyector);

  
  });

  $("#labDetailsModal").on("show.bs.modal", function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
  
    var pc = button.data("pc");
    var sillas = button.data("sillas");

    var modal = $(this);
  
    modal.find("#classroomPc").text(pc);
    modal.find("#classroomSillas").text(sillas);

  
  });

  $("#deleteModal").on("show.bs.modal", function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
  
    var id = button.data("id"); // Extract info from data-* attributes
    var content = button.data("content");
    var modal = $(this);

    var deleteLink = "/delete/"+id
  
    modal.find("#itemIdDelete").attr("action", deleteLink);
    modal.find("#itemContentDelete").text(content);
  
  });