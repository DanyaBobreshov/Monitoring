<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template industrial>
    <hr>
        <form action="industrial-edit/${industrial.id}" method="post">
             <div class="form-group">
                            <label for="title">Наименование</label>
                            <input type="text" value="${industrial.title}"required class="form-control"
                                   id="title" name="title">
                        </div>
                        <div class="form-group">
                           <label for="address">Адрес</label>
                           <input type="text" value="${industrial.address}"required class="form-control"
                           id="address" name="address">
                                    </div>
                         <div class="form-group">
                            <label for="director">Директор</label>
                            <input type="text" value="${industrial.director}" required class="form-control"
                            id="director" name="director">
                            </div>
                         <div class="form-group">
                           <label for="directorName">Имя Отчество</label>
                          <input type="text" value="${industrial.directorName}" required class="form-control"
                           id="directorName" name="directorName">
                           </div>
                           <div class="form-group">
                            <label for="contactManager">Представитель</label>
                            <input type="text" value="${industrial.contactManager.name}" required class="form-control"
                             id="contactManager" name="contactManager">
                             </div>
                        </div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>