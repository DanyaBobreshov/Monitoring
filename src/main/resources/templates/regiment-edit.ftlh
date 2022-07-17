<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template regiment>
    <hr>
        <form action="regiment-edit/${regiment.id}" method="post">
                   <div class="form-group">
                       <label for="title">Наименование</label>
                       <input type="text" value="${regiment.title}" required class="form-control"
                              id="title" name="title">
                   </div>
                   <div class="form-group">
                      <label for="address">Адрес</label>
                      <input type="text" value="${regiment.address}" required class="form-control"
                      id="address" name="address">
                               </div>
                    <div class="form-group">
                       <label for="division">ОВУ</label>
                       <input type="text" value="${regiment.division.title}" required class="form-control"
                       id="division" name="division">
                       </div>
                   </div>
                   <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>