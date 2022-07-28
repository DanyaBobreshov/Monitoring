<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Неисправности</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Изделие наименование</th>
                    <th scope="col">Изделие серийный номер</th>
                    <th scope="col">Гарантийное</th>
                    <th scope="col">Описание</th>
                    <th scope="col">Дата</th>
                    <th scope="col">Предприятие</th>
                    <th scope="col">Документ</th>
                </tr>
                <#list incidents as incident>
                <tr>
                    <th>${incident.id}</th>
                    <th>${incident.product.modelOfTechnical.title}</th>
                    <th>${incident.product.serialNumber}</th>
                    <th>${incident.isGarant?c}</th>
                    <th>${incident.description}</th>
                    <th>${incident.dateOfIncident}</th>
                    <th>${incident.industrial.title}</th>
                    <th>${incident.document}</th>
                    <th><a href="/incidents/edit/${incident.id}">Редактировние</a></th>
                    <th><a href="/incidents/delete/${incident.id}">Удаление</a></th>
                </tr>
                <#else>
                <h3>Неисправностей нет</h3>
            </#list>
            </table>
    <form method="get" action="/incidents">
            <div class="form-group col-md-10">
                <label for="searchWord">Поиск по дате</label>
                <input type="date" name="searchWord" <#if searchWord??>value="${searchWord}"</#if> class="form-control"
                       id="searchWord">
            </div>
            <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
    </form>
    <hr>
 <hr>
    <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
       data-toggle="collapse" href="#collapseExample" role="button"
       aria-expanded="true" aria-controls="collapseExample">
        Добавить неисправность
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/incidents/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="product">Изделие</label>
                <input type="text" required class="form-control"
                       id="product" name="product">
            </div>
             <div class="form-group">
                <label for="isGarant">Гарантийный ремонт</label>
               <input type="checkbox" <#if isGarant??>value="${false}"</#if>
               id="isGarant"  name="isGarant">
                </div>
             <div class="form-group">
                 <label for="description">Описание</label>
                 <input type="text" required class="form-control"
                        id="description" name="description">
             </div>
              <div class="form-group">
                  <label for="dateOfIncident">Дата выявления</label>
                  <input type="date" required class="form-control"
                         id="dateOfIncident" name="dateOfIncident">
              </div>
              <div class="form-group">
                <label for="industrial">Предприятие</label>
                <input type="text" required class="form-control"
              id="industrial" name="industrial">
             </div>
              <div class="form-group">
                <label for="document">Документы</label>
                <input type="text" required class="form-control"
              id="document" name="document">
             </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                        <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
        <hr>
 </div>
   </@t.template>