<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template modelOfTechnical>
    <hr>
        <form action="modelOfTechnical-edit/${modelOfTechnical.id}" method="post">
                      <div class="form-group">
                          <label for="modelOfTechnicalTitle">Наименование</label>
                          <input type="text" value="${modelOfTechnical.title}"required class="form-control"
                                 id="modelOfTechnicalTitle" name="title">
                      </div>
                       <div class="form-group">
                          <label for="description">Описание</label>
                          <input type="text" value="${modelOfTechnical.description}" required class="form-control"
                          id="description" name="description">
                          </div>
               <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>