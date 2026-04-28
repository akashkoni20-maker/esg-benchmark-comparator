@PutMapping("/{id}")
public AuditLog update(@PathVariable Long id, @RequestBody AuditLog updated) {
    AuditLog log = repository.findById(id).orElseThrow();

    log.setAction(updated.getAction());
    log.setUsername(updated.getUsername());
    log.setDescription(updated.getDescription());

    return repository.save(log);
}

@DeleteMapping("/{id}")
public String softDelete(@PathVariable Long id) {
    AuditLog log = repository.findById(id).orElseThrow();

    log.setDeleted(true);
    repository.save(log);

    return "Deleted Successfully";
}

@GetMapping("/search")
public List<AuditLog> search(@RequestParam String q) {
    return repository.findByActionContainingIgnoreCase(q);
}