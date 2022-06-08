
  // MODALS DETAILS
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

  // MODALS PETITION NOTE ACTIONS
  $("#traditionalPetitionDetailsModal").on("show.bs.modal", function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
  
    var bancos = button.data("bancos");
    var pizarron = button.data("pizarron");
    var proyector = button.data("proyector");
    var petitonId = button.data("petitionid");
    var spaceId = button.data("spaceid");

    console.log(spaceId)

    var acceptLink = "/petitions/accept/"+petitonId+"/for-space/"+spaceId

    var modal = $(this);
  

    if(proyector){
      proyector = "✅ Si"
    } else {
      proyector = "❌ No"
    }

    modal.find("#classroomBancos").text(bancos);
    modal.find("#classroomPizarron").text(pizarron);
    modal.find("#classroomProyector").text(proyector);

    modal.find("#acceptLink").attr("action", acceptLink);

  });

  $("#labDetailsPetitionModal").on("show.bs.modal", function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
  
    var pc = button.data("pc");
    var sillas = button.data("sillas");
    var petitonId = button.data("petitionid");
    var spaceId = button.data("spaceid");

    var acceptLink = "/petitions/accept/"+petitonId+"/for-space/"+spaceId

    var modal = $(this);
  
    modal.find("#classroomPc").text(pc);
    modal.find("#classroomSillas").text(sillas);
 
    modal.find("#acceptLink").attr("action", acceptLink);
  
  });

  $("#deleteModal").on("show.bs.modal", function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
  
    var id = button.data("id"); // Extract info from data-* attributes
    var content = button.data("content");
    var modal = $(this);

    var type = button.data("type");
    var deleteLink;

    if (type == "user") {
      deleteLink = "/delete/"+id
    } else if (type == "classroom"){
      deleteLink = "/classroom/delete/"+id
    } else if (type == "building"){
      deleteLink = "/building/delete/"+id
    }
  
    modal.find("#itemIdDelete").attr("action", deleteLink);
    modal.find("#itemContentDelete").text(content);
  
  });
