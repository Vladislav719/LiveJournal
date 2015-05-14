<form role="form" id="post-form" class="contact-form" method="post" action="/app/post/edit">
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
        <select class="form-control">
          <option value="OPEN">Open</option>
          <option value="PROTECTED">Protected</option>
          <option value="SECRET">Secret</option>
        </select>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-md-12">
      <button type="submit" class="btn main-btn pull-right">Send a message</button>
    </div>
  </div>
</form>
<script>
  loadCSS("/resources/css/post_form.css");
</script>