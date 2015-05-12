<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>
<form role="form" id="post-form" class="contact-form" method="post" action="/app/post">
  <div class="row">
    <div class="col-md-offset-2"></div>
    <div class="col-md-10">
      <div class="form-group">
        <input type="text" class="form-control" name="title" autocomplete="off" id="Name" placeholder="Title">
      </div>
    </div>

  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="form-group">
        <textarea class="form-control textarea" rows="3" name="message" id="message" placeholder="Your post here"></textarea>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-md-8">
      <div class="form-group">
        <input name="tags" type="text" class="form-control " id="tags" value=""/>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-md-12">
      <button type="submit" class="btn main-btn pull-right">Send a message</button>
    </div>
  </div>
</form>
<script src="/resources/js/bundle.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tokenfield/0.12.0/bootstrap-tokenfield.min.js"></script>
<script>
  loadCSS("/resources/css/post_form.css");
  loadCSS("https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tokenfield/0.12.0/css/bootstrap-tokenfield.css");
  loadCSS("https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tokenfield/0.12.0/css/tokenfield-typeahead.css");

//  var engine = new Bloodhound({
//    local: [{value: 'red'}, {value: 'blue'}, {value: 'green'} , {value: 'yellow'}, {value: 'violet'}, {value: 'brown'}, {value: 'purple'}, {value: 'black'}, {value: 'white'}],
//    datumTokenizer: function(d) {
//      return Bloodhound.tokenizers.whitespace(d.value);
//    },
//    queryTokenizer: Bloodhound.tokenizers.whitespace
//  });
//
//  engine.initialize();
  $('#tags').tokenfield({
    autocomplete: {
      source: '/app/tag/all.json',
      delay: 100
    },
    showAutocompleteOnFocus: false
  });
//  $('#tags').tokenfield({
//    typeahead: [null, { source: engine.ttAdapter() }]
//  });

  $('#post-form').bootstrapValidator({
//        live: 'disabled',
    message: 'This field is not valid',
    feedbackIcons: {
      valid: 'glyphicon glyphicon-ok',
      invalid: 'glyphicon glyphicon-remove',
      validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
      Name: {
        validators: {
          notEmpty: {
            message: 'The Title is required and cannot be empty'
          }
        }
      },

      message: {
        validators: {
          notEmpty: {
            message: 'The Message is required and cannot be empty'
          }
        }
      }
    }
  });
</script>