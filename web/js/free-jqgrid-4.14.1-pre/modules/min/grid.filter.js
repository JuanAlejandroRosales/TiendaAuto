!function(a,b){"use strict";"function"==typeof define&&define.amd?define(["jquery","./grid.base","./grid.common"],function(c){return b(c,a)}):"object"==typeof module&&module.exports?module.exports=function(a,c){return a||(a=window),void 0===c&&(c="undefined"!=typeof window?require("jquery"):require("jquery")(a)),require("./grid.base"),require("./grid.common"),b(c,a),c}:b(jQuery,a)}("undefined"!=typeof window?window:this,function(a,b){"use strict";var c=a.jgrid;a.fn.jqFilter=function(d){if("string"==typeof d){var e=a.fn.jqFilter[d];if(!e)throw"jqFilter - No such method: "+d;var f=a.makeArray(arguments).slice(1);return e.apply(this,f)}var g=a.extend(!0,{filter:null,columns:[],onChange:null,afterRedraw:null,error:!1,errmsg:"",errorcheck:!0,showQuery:!0,sopt:null,ops:[],operands:null,numopts:["eq","ne","lt","le","gt","ge","nu","nn","in","ni"],stropts:["eq","ne","bw","bn","ew","en","cn","nc","nu","nn","in","ni"],strarr:["text","string","blob"],groupOps:[{op:"AND",text:"AND"},{op:"OR",text:"OR"}],groupButton:!0,ruleButtons:!0,direction:"ltr"},c.filter,d||{});return this.each(function(){if(!this.filter){this.p=g,null!==g.filter&&void 0!==g.filter||(g.filter={groupOp:g.groupOps[0].op,rules:[],groups:[]});var d,e,f=g.columns.length,h=/msie/i.test(navigator.userAgent)&&!b.opera,i=a.isFunction,j=null!=c.defaults&&i(c.defaults.fatalError)?c.defaults.fatalError:alert,k=function(){return a("#"+c.jqID(g.id))[0]||null},l=function(b,c){return a(k()).jqGrid("getGuiStyles",b,c||"")},m=function(b){return a(k()).jqGrid("getGridRes","search."+b)},n=function(a){var b=k(),c=b.p.iColByName[a];return void 0!==c?{cm:b.p.colModel[c],iCol:c}:(c=b.p.iPropByName[a],void 0!==c?{cm:b.p.additionalProperties[c],iCol:c,isAddProp:!0}:{cm:null,iCol:-1})},o=l("states.error"),p=l("dialog.content");if(g.initFilter=a.extend(!0,{},g.filter),f){for(d=0;d<f;d++)e=g.columns[d],e.stype?e.inputtype=e.stype:e.inputtype||(e.inputtype="text"),e.sorttype?e.searchtype=e.sorttype:e.searchtype||(e.searchtype="string"),void 0===e.hidden&&(e.hidden=!1),e.label||(e.label=e.name),e.cmName=e.name,e.index&&(e.name=e.index),e.hasOwnProperty("searchoptions")||(e.searchoptions={}),e.hasOwnProperty("searchrules")||(e.searchrules={});g.showQuery&&a(this).append("<table class='queryresult "+p+"' style='display:block;max-width:440px;border:0px none;' dir='"+g.direction+"'><tbody><tr><td class='query'></td></tr></tbody></table>");var q=function(a,b){var d=[!0,""],e=k();if(i(b.searchrules))d=b.searchrules.call(e,a,b);else if(c&&c.checkValues)try{d=c.checkValues.call(e,a,-1,b.searchrules,b.label)}catch(a){}d&&d.length&&!1===d[0]&&(g.error=!d[0],g.errmsg=d[1])};this.onchange=function(){return g.error=!1,g.errmsg="",!!i(g.onChange)&&g.onChange.call(k(),g,this)},this.reDraw=function(){a("table.group:first",this).remove();var b=this.createTableForGroup(g.filter,null);a(this).append(b),i(g.afterRedraw)&&g.afterRedraw.call(k(),g,this)},this.createTableForGroup=function(b,c){var d,e=this,f=a("<table class='"+l("searchDialog.operationGroup","group")+"' style='border:0px none;'><tbody></tbody></table>"),h="left";"rtl"===g.direction&&(h="right",f.attr("dir","rtl")),null===c&&f.append("<tr class='error' style='display:none;'><th colspan='5' class='"+o+"' align='"+h+"'></th></tr>");var i=a("<tr></tr>");f.append(i);var j=a("<th colspan='5' align='"+h+"'></th>");if(i.append(j),!0===g.ruleButtons){var k=a("<select class='"+l("searchDialog.operationSelect","opsel")+"'></select>");j.append(k);var n,p="";for(d=0;d<g.groupOps.length;d++)n=b.groupOp===e.p.groupOps[d].op?" selected='selected'":"",p+="<option value='"+e.p.groupOps[d].op+"'"+n+">"+e.p.groupOps[d].text+"</option>";k.append(p).on("change",function(){b.groupOp=a(k).val(),e.onchange()})}var q="<span></span>";if(g.groupButton&&(q=a("<input type='button' value='+ {}' title='"+m("addGroupTitle")+"' class='"+l("searchDialog.addGroupButton","add-group")+"'/>"),q.on("click",function(){return void 0===b.groups&&(b.groups=[]),b.groups.push({groupOp:g.groupOps[0].op,rules:[],groups:[]}),e.reDraw(),e.onchange(),!1})),j.append(q),!0===g.ruleButtons){var r,s=a("<input type='button' value='+' title='"+m("addRuleTitle")+"' class='"+l("searchDialog.addRuleButton","add-rule ui-add")+"'/>");s.on("click",function(){var c,f;for(void 0===b.rules&&(b.rules=[]),d=0;d<e.p.columns.length;d++)if(c=void 0===e.p.columns[d].search||e.p.columns[d].search,f=!0===e.p.columns[d].hidden,!0===e.p.columns[d].searchoptions.searchhidden&&c||c&&!f){r=e.p.columns[d];break}var g;return g=r.searchoptions.sopt?r.searchoptions.sopt:e.p.sopt?e.p.sopt:-1!==a.inArray(r.searchtype,e.p.strarr)?e.p.stropts:e.p.numopts,b.rules.push({field:r.name,op:g[0],data:""}),e.reDraw(),!1}),j.append(s)}if(null!==c){var t=a("<input type='button' value='-' title='"+m("deleteGroupTitle")+"' class='"+l("searchDialog.deleteGroupButton","delete-group")+"'/>");j.append(t),t.on("click",function(){for(d=0;d<c.groups.length;d++)if(c.groups[d]===b){c.groups.splice(d,1);break}return e.reDraw(),e.onchange(),!1})}if(void 0!==b.groups){var u,v,w;for(d=0;d<b.groups.length;d++)u=a("<tr></tr>"),f.append(u),v=a("<td class='first'></td>"),u.append(v),w=a("<td colspan='4'></td>"),w.append(this.createTableForGroup(b.groups[d],b)),u.append(w)}if(void 0===b.groupOp&&(b.groupOp=e.p.groupOps[0].op),void 0!==b.rules)for(d=0;d<b.rules.length;d++)f.append(this.createTableRowForRule(b.rules[d],b));return f},this.createTableRowForRule=function(b,d){var e,f,j,o,p=this,q=k(),r=a("<tr></tr>"),s="";r.append("<td class='first'></td>");var t=a("<td class='columns'></td>");r.append(t);var u,v=a("<select class='"+l("searchDialog.label","selectLabel")+"'></select>"),w=[];t.append(v),v.on("change",function(){b.field=a(v).val();var d,e,g=a(this).parents("tr:first");for(e=0;e<p.p.columns.length;e++)if(p.p.columns[e].name===b.field){d=p.p.columns[e];break}if(d){var j=a.extend({},d.editoptions||{});delete j.readonly,delete j.disabled;var k=a.extend({},j||{},d.searchoptions||{},n(d.cmName),{id:c.randId(),name:d.name,mode:"search"});k.column=d,h&&"text"===d.inputtype&&(k.size||(k.size=10));var m=c.createEl.call(q,d.inputtype,a.extend({},k,k.attr||{}),"",!0,p.p.ajaxSelectOptions||{},!0);a(m).addClass(l("searchDialog.elem","input-elm")),f=k.sopt?k.sopt:p.p.sopt?p.p.sopt:-1!==a.inArray(d.searchtype,p.p.strarr)?p.p.stropts:p.p.numopts;var o,r,s,t="",x=0;for(w=[],a.each(p.p.ops,function(){w.push(this.oper)}),p.p.cops&&a.each(p.p.cops,function(a){w.push(a)}),e=0;e<f.length;e++)r=f[e],-1!==(u=a.inArray(f[e],w))&&(o=p.p.ops[u],s=void 0!==o?o.text:p.p.cops[r].text,0===x&&(b.op=r),t+="<option value='"+r+"'>"+s+"</option>",x++);if(a(".selectopts",g).empty().append(t),a(".selectopts",g)[0].selectedIndex=0,c.msie&&c.msiever()<9){var y=parseInt(a("select.selectopts",g)[0].offsetWidth,10)+1;a(".selectopts",g).width(y),a(".selectopts",g).css("width","auto")}a(".data",g).empty().append(m),c.bindEv.call(q,m,k),a(".input-elm",g).on("change",k,function(c){var d=c.target,e=c.data.column;b.data=e&&"custom"===e.inputtype&&i(e.searchoptions.custom_value)?e.searchoptions.custom_value.call(q,a(this).find(".customelement").first(),"get"):d.value,a(d).is("input[type=checkbox]")&&!a(d).is(":checked")&&(b.data=a(d).data("offval")),p.onchange()}),setTimeout(function(){b.data=a(m).val(),p.onchange()},0)}});var x,y,z=0;for(e=0;e<p.p.columns.length;e++)x=void 0===p.p.columns[e].search||p.p.columns[e].search,y=!0===p.p.columns[e].hidden,(!0===p.p.columns[e].searchoptions.searchhidden&&x||x&&!y)&&(o="",b.field===p.p.columns[e].name&&(o=" selected='selected'",z=e),s+="<option value='"+p.p.columns[e].name+"'"+o+">"+p.p.columns[e].label+"</option>");v.append(s);var A=a("<td class='operators'></td>");r.append(A),j=g.columns[z],h&&"text"===j.inputtype&&(j.searchoptions.size||(j.searchoptions.size=10));var B=a.extend({},j.editoptions||{});delete B.readonly,delete B.disabled;var C=a.extend({},B,j.searchoptions||{},n(j.cmName),{id:c.randId(),name:j.name});C.column=j;var D=c.createEl.call(q,j.inputtype,a.extend({},C,C.attr||{}),b.data,!0,p.p.ajaxSelectOptions||{},!0);("nu"===b.op||"nn"===b.op||a.inArray(b.op,q.p.customUnaryOperations)>=0)&&(a(D).attr("readonly","true"),a(D).attr("disabled","true"));var E=a("<select class='"+l("searchDialog.operator","selectopts")+"'></select>");A.append(E),E.on("change",function(){b.op=a(E).val();var c=a(this).parents("tr:first"),d=a(".input-elm",c)[0];"nu"===b.op||"nn"===b.op||a.inArray(b.op,q.p.customUnaryOperations)>=0?(b.data="","SELECT"!==d.tagName.toUpperCase()&&(d.value=""),d.setAttribute("readonly","true"),d.setAttribute("disabled","true")):("SELECT"===d.tagName.toUpperCase()&&(b.data=d.value),d.removeAttribute("readonly"),d.removeAttribute("disabled")),p.onchange()}),f=j.searchoptions.sopt?j.searchoptions.sopt:p.p.sopt?p.p.sopt:-1!==a.inArray(j.searchtype,p.p.strarr)?p.p.stropts:p.p.numopts,s="";var F,G;for(a.each(p.p.ops,function(){w.push(this.oper)}),p.p.cops&&a.each(p.p.cops,function(a){w.push(a)}),e=0;e<f.length;e++)G=f[e],-1!==(u=a.inArray(f[e],w))&&(F=p.p.ops[u],o=b.op===G?" selected='selected'":"",s+="<option value='"+G+"'"+o+">"+(void 0!==F?F.text:p.p.cops[G].text)+"</option>");E.append(s);var H=a("<td class='data'></td>");r.append(H),H.append(D),c.bindEv.call(q,D,j.searchoptions),a(D).addClass(l("searchDialog.elem","input-elm")).on("change",function(){b.data="custom"===j.inputtype?j.searchoptions.custom_value.call(q,a(this).find(".customelement").first(),"get"):a(this).val(),a(this).is("input[type=checkbox]")&&!a(this).is(":checked")&&(b.data=a(this).data("offval")),a.isArray(b.data)&&(b.data=b.data.join(g.inFilterSeparator||",")),p.onchange()});var I=a("<td></td>");if(r.append(I),!0===g.ruleButtons){var J=a("<input type='button' value='-' title='"+m("deleteRuleTitle")+"' class='"+l("searchDialog.deleteRuleButton","delete-rule ui-del")+"'/>");I.append(J),J.on("click",function(){for(e=0;e<d.rules.length;e++)if(d.rules[e]===b){d.rules.splice(e,1);break}return p.reDraw(),p.onchange(),!1})}return r},this.getStringForGroup=function(a){var b,c="(";if(void 0!==a.groups)for(b=0;b<a.groups.length;b++){c.length>1&&(c+=" "+a.groupOp+" ");try{c+=this.getStringForGroup(a.groups[b])}catch(a){j(a)}}if(void 0!==a.rules)try{for(b=0;b<a.rules.length;b++)c.length>1&&(c+=" "+a.groupOp+" "),c+=this.getStringForRule(a.rules[b])}catch(a){j(a)}return c+=")","()"===c?"":c},this.getStringForRule=function(b){var c,d,e,f="",h="",j=b.data,l=["int","integer","float","number","currency"];for(c=0;c<g.ops.length;c++)if(g.ops[c].oper===b.op){f=g.operands.hasOwnProperty(b.op)?g.operands[b.op]:"",h=g.ops[c].oper;break}if(""===h&&null!=g.cops)for(e in g.cops)if(g.cops.hasOwnProperty(e)&&(h=e,f=g.cops[e].operand,i(g.cops[e].buildQueryValue)))return g.cops[e].buildQueryValue.call(g,{cmName:b.field,searchValue:j,operand:f});for(c=0;c<g.columns.length;c++)if(g.columns[c].name===b.field){d=g.columns[c];break}return null==d?"":("bw"!==h&&"bn"!==h||(j+="%"),"ew"!==h&&"en"!==h||(j="%"+j),"cn"!==h&&"nc"!==h||(j="%"+j+"%"),"in"!==h&&"ni"!==h||(j=" ("+j+")"),g.errorcheck&&q(b.data,d),-1!==a.inArray(d.searchtype,l)||"nn"===h||"nu"===h||a.inArray(h,k().p.customUnaryOperations)>=0?b.field+" "+f+" "+j:b.field+" "+f+' "'+j+'"')},this.resetFilter=function(){g.filter=a.extend(!0,{},g.initFilter),this.reDraw(),this.onchange()},this.hideError=function(){a("th."+o,this).html(""),a("tr.error",this).hide()},this.showError=function(){a("th."+o,this).html(g.errmsg),a("tr.error",this).show()},this.toUserFriendlyString=function(){return this.getStringForGroup(g.filter)},this.toString=function(){function a(a){if(c.p.errorcheck){var b,d;for(b=0;b<c.p.columns.length;b++)if(c.p.columns[b].name===a.field){d=c.p.columns[b];break}d&&q(a.data,d)}return a.op+"(item."+a.field+",'"+a.data+"')"}function b(c){var d,e="(";if(void 0!==c.groups)for(d=0;d<c.groups.length;d++)e.length>1&&("OR"===c.groupOp?e+=" || ":e+=" && "),e+=b(c.groups[d]);if(void 0!==c.rules)for(d=0;d<c.rules.length;d++)e.length>1&&("OR"===c.groupOp?e+=" || ":e+=" && "),e+=a(c.rules[d]);return e+=")","()"===e?"":e}var c=this;return b(g.filter)},this.reDraw(),g.showQuery&&this.onchange(),this.filter=!0}}})},a.extend(a.fn.jqFilter,{toSQLString:function(){var a="";return this.each(function(){a=this.toUserFriendlyString()}),a},filterData:function(){var a;return this.each(function(){a=this.p.filter}),a},getParameter:function(a){return void 0!==a&&this.p.hasOwnProperty(a)?this.p[a]:this.p},resetFilter:function(){return this.each(function(){this.resetFilter()})},addFilter:function(b){"string"==typeof b&&(b=a.parseJSON(b)),this.each(function(){this.p.filter=b,this.reDraw(),this.onchange()})}})});
//# sourceMappingURL=grid.filter.js.map