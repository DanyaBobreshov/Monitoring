<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template performer>
    <hr>
        <form action="performer-edit/${performer.id}" method="post">
             <div class="form-group">
                            <label for="name">Имя</label>
                            <input type="text" value="${performer.name}" required class="form-control"
                                   id="name" name="name">
                        </div>
                         <div class="form-group">
                            <label for="phoneNumber">Телефонный номер</label>
                            <input type="text"  value="${performer.phoneNumber}"required class="form-control"
                            id="phoneNumber" name="phoneNumber">
                            </div>
                        </div>
                        <div class="form-group">
                          <label for="reservePhoneNumber">Резервный телефонный номер</label>
                          <input type="text" value="${performer.reservePhoneNumber}" required class="form-control"
                          id="reservePhoneNumber" name="reservePhoneNumber">
                                        </div>
                                    </div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>