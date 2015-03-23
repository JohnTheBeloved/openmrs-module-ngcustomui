
<%
    ui.includeJavaScript("ngcustomui", "jquery.js")
    <%= ui.resourceLinks() %>

    def id = config.id
    def props = config.properties ?: ["encounterType", "encounterDatetime", "location", "provider"]
%>
<script>
    jq = jQuery;

    jq(function(){
        jq('#${ id }_button').click(function(){
            {
                'start': '${config.start'
            }
        };)
    });
</script>
<table>
    <tr>
        <% props.each { %>
            <th>${ ui.message("Encounter." + it) }</th>
        <% } %>
    </tr>
    <% if (encounters) { %>
        <% encounters.each { enc -> %>
            <tr>
                <% props.each { prop -> %>
                    <td><%= ui.format(enc."${prop}") %></td>
                <% } %>
            </tr>
        <% } %>
    <% } else { %>
        <tr>
            <td colspan="4">${ ui.message("general.none") }</td>
        </tr>
    <% } %>
</table>