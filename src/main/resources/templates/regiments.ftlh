<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Войскоавя часть</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Наименование</th>
                    <th scope="col">адрес</th>
                    <th scope="col">ОВУ</th>
                </tr>
                <#list regiments as regiment>
                <tr>
                    <th>${regiment.id}</th>
                    <th>${regiment.title}</th>
                    <th>${regiment.address}</th>
                    <th>${regiment.division.title}</th>
                    <th><a href="/regiment/edit/${regiment.id}">Редактировние</a></th>
                    <th><a href="/regiment/delete/${regiment.id}">Удаление</a></th>
                </tr>
                <#else>
                <h3>Организаций нет</h3>
            </#list>
            </table>
    <form method="get" action="/regiments">
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
        Добавить в/ч
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/regiments/add" method="post" enctype="multipart/form-data">
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
                <label for="division">ОВУ</label>
                <input type="text" required class="form-control"
                id="division" name="division">
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                        <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
        <hr>
 </div>
   </@t.template>