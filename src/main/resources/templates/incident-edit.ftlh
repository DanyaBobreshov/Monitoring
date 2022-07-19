<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template incident>
    <hr>
        <form action="incident-edit/${incident.id}" method="post">
            <div class="form-group">
                            <label for="product">Изделие</label>
                            <input type="text" value="${incident.product.id}" required class="form-control"
                                   id="product" name="product">
                        </div>
                         <div class="form-group">
                            <label for="isGarant">Гарантийный ремонт</label>
                           <input type="checkbox" required class="form-control"
                           id="isGarant"  name="isGarant">
                            </div>
                        </div>
                         <div class="form-group">
                             <label for="description">Описание</label>
                             <input type="text" value="${incident.description}"required class="form-control"
                                    id="description" name="description">
                         </div>
                          <div class="form-group">
                              <label for="dateOfIncident">Дата выявления</label>
                              <input type="date" value="${incident.dateOfIncident}"required class="form-control"
                                     id="dateOfIncident" name="dateOfIncident">
                          </div>
              <div class="form-group">
                <label for="industrial">Предприятие</label>
                <input type="text"  value="${incident.industrial.title}" required class="form-control"
              id="industrial" name="industrial">
             </div>
              <div class="form-group">
                <label for="document">Документы</label>
                <input type="text"  value="${incident.document}" required class="form-control"
              id="document" name="document">
             </div>
               <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>