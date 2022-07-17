<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Исполнитель</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Имя</th>
                    <th scope="col">Телефон</th>
                    <th scope="col">Резервный телефонный номер</th>
                </tr>
                <#list performers as performer>
                <tr>
                    <th>${performer.id}</th>
                    <th>${performer.name}</th>
                    <th>${performer.phoneNumber}</th>
                    <th>${performer.reservePhoneNumber}</th>
                    <th><a href="/performer/edit/${performer.id}">Редактировние</a></th>
                    <th><a href="/performer/delete/${performer.id}">Удаление</a></th>
                </tr>
                <#else>
                <h3>Исполнителей нет</h3>
            </#list>
            </table>
    <form method="get" action="/performers">
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
        Добавить нового исполнителя
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/performer/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Имя</label>
                <input type="text" required class="form-control"
                       id="name" name="name">
            </div>
             <div class="form-group">
                <label for="phoneNumber">Телефонный номер</label>
                <input type="text" required class="form-control"
                id="phoneNumber" name="phoneNumber">
                </div>
            </div>
            <div class="form-group">
              <label for="reservePhoneNumber">Резервный телефонный номер</label>
              <input type="text" required class="form-control"
              id="reservePhoneNumber" name="reservePhoneNumber">
                            </div>
                        </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

            <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
 </div>
   </@t.template>