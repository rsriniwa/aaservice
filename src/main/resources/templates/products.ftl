<import "spring.ftl" as spring>

<html>
<h1> My products</h1>

<ul>

    <#list products as product>
        <li>${product}</li>
    </#list>

</ul>
<br>

<a href="/logout?domain=coke">Coke logout</a>

</br>

<a href="/logout?domain=pepsi">Pepsi logout</a>
</html>
