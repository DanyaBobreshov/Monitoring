<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Предприятия промышленности</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Наименование</th>
                    <th scope="col">Адрес</th>
                    <th scope="col">Директор</th>
                    <th scope="col">Имя Отчество директора</th>
                    <th scope="col">Представитель</th>
                </tr>
                <#list industrials as industrial>
                <tr>
                    <th>${industrial.id}</th>
                    <th>${industrial.title}</th>
                    <th>${industrial.address}</th>
                    <th>${industrial.director}</th>
                    <th>${industrial.directorName}</th>
                    <th>${industrial.contactManager.name}</th>
                    <th><a href="/industrial/edit/${industrial.id}">Редактировние</a></th>
                    <th><a href="/industrial/delete/${industrial.id}">Удаление</a></th>
                </tr>
                <#else>
                <h3>Организаций нет</h3>
            </#list>
            </table>
    <form method="get" action="/industrials">
            <div class="form-group col-md-10">
                <label for="searchWord">Поиск по организациям</label>
                <input type="text" name="searchWord" <#if searchWord??>value="${searchWord}"</#if> class="form-control"
                       id="searchWord">
            </div>
            <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
    </form>
    <hr>
 <hr>
    <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
       data-toggle="collapse" href="#collapseExample" role="button"
       aria-expanded="true" aria-controls="collapseExample">
        Добавить новое предприятие
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/industrial/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="title">Наименование</label>
                <input type="text" required class="form-control"
                       id="title" name="title">
            </div>
            <div class="form-group">
               <label for="address">Адрес</label>
               <input type="text" required class="form-control"
               id="address" name="address">
                        </div>
             <div class="form-group">
                <label for="director">Директор</label>
                <input type="text" required class="form-control"
                id="director" name="director">
                </div>
             <div class="form-group">
               <label for="directorName">Имя Отчество</label>
              <input type="text" required class="form-control"
               id="directorName" name="directorName">
               </div>
               <div class="form-group">
                <label for="contactManager">Представитель</label>
                <input type="text" required class="form-control"
                 id="contactManager" name="contactManager">
                 </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
        <hr>
            <a href="/performers">Добавить исполнителя</a></h2>
        <hr>
 </div>
   </@t.template>